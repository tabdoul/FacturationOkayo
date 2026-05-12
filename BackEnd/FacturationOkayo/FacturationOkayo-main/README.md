# API 

Cette API permet de gérer le catalogue d’articles, les clients, les émetteurs et la création de factures pour la société **Okayo**. Elle est construite avec **Spring Boot / Java ** et utilise **** pour la persistance.

---

## Fonctionnalités principales

### 1️- Gestion des articles

- Chaque article possède un code unique et une description.  
- Les prix et taux de TVA évoluent via des **caractéristiques historiques**, figées par période.  
- Les informations des articles (code, description) sont immuables après création.  

**Routes :**

| Méthode | URL                                      | Description                                |
|---------|------------------------------------------|--------------------------------------------|
| GET     | `/api/articles`                          | Liste tous les articles                     |
| GET     | `/api/articles/{id}`                     | Détail d’un article                         |
| POST    | `/api/articles`                          | Créer un nouvel article                     |
| POST    | `/api/articles/{id}/caracteristiques`   | Ajouter une nouvelle caractéristique (prix/TVA) |
| GET     | `/api/articles/{id}/caracteristiques`   | Lister toutes les caractéristiques d’un article |

---

### 2️- Gestion des clients

- Chaque client a un code unique, une adresse, un code postal et une ville.  
- Les informations peuvent être modifiées après création, sauf le code unique.  

**Routes :**

| Méthode | URL                   | Description                     |
|---------|----------------------|---------------------------------|
| GET     | `/api/clients`        | Liste tous les clients          |
| GET     | `/api/clients/{id}`   | Détail d’un client             |
| POST    | `/api/clients`        | Créer un nouveau client        |
| PUT     | `/api/clients/{id}`   | Mettre à jour un client        |
| DELETE  | `/api/clients/{id}`   | Supprimer un client (optionnel)|

---

### 3️- Gestion des émetteurs

- Chaque émetteur représente un fournisseur ou émetteur de factures.  
- Les informations sont toutes modifiables.  

**Routes :**

| Méthode | URL                    | Description                     |
|---------|-----------------------|---------------------------------|
| GET     | `/api/emetteurs`       | Liste tous les émetteurs        |
| GET     | `/api/emetteurs/{id}`  | Détail d’un émetteur            |
| POST    | `/api/emetteurs`       | Créer un émetteur               |
| PUT     | `/api/emetteurs/{id}`  | Mettre à jour un émetteur       |
| DELETE  | `/api/emetteurs/{id}`  | Supprimer un émetteur           |

---

### 4️- Gestion des factures

- Chaque facture est liée à un client et un émetteur.  
- Chaque ligne de facture est créée à partir du catalogue et **fige le prix et la TVA à la date de facturation**.  
- Les totaux HT et TTC sont calculés automatiquement.  
- Seule la date d’échéance peut être modifiée après création.  

**Routes :**

| Méthode | URL                                         | Description                       |
|---------|---------------------------------------------|-----------------------------------|
| GET     | `/api/factures`                             | Liste toutes les factures         |
| GET     | `/api/factures/{id}`                        | Détail d’une facture              |
| POST    | `/api/factures?clientId=...&emetteurId=...` | Créer une facture avec plusieurs lignes |
| PUT     | `/api/factures/{id}/echeance?newDateEcheance=YYYY-MM-DD` | Mettre à jour la date d’échéance |

---

## Exemple JSON pour créer une facture

```json
{
  "ref_facture": "FACT-2025-001",
  "date_facturation": "2025-09-28",
  "date_echeance": "2025-10-28",
  "lignes": [
    {"articleId": 1, "quantite": 3},
    {"articleId": 2, "quantite": 2}
  ]
}
## Améliorations possibles

1. **Gestion propre des exceptions**  
   - Créer un `@ControllerAdvice` global pour gérer les erreurs et renvoyer des messages clairs et standardisés (400, 404, 500).  

2. **Validation des données**  
   - Utiliser `@Valid` et des annotations comme `@NotBlank`, `@Positive` sur les DTO pour valider les entrées côté API.  
   - Vérifier les contraintes métiers : quantités > 0, dates cohérentes, code unique pour articles et clients.  

3. **Documentation OpenAPI / Swagger**  
   - Ajouter `springdoc-openapi` pour générer automatiquement une documentation interactive.  
   - Permet de tester toutes les routes directement via Swagger UI.  

6. ** Tests unitaires et d’intégration**  
   - Couvrir tous les services et contrôleurs pour garantir la robustesse de l’API.# FacturationOkayo
# FacturationOkayo
