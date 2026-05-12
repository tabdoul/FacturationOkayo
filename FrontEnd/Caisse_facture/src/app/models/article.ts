import { Detail } from "./detail";

export interface Caracteristique {
  idCaracteristique: {
    id_article: number;
    date_debut: string;
  };
  nom: string;
  prix: number;
  tva: number;
  date_fin: string;
}

export interface Article {
  id_article?: number;
  code_article: string;
  description: string;
  caracteristiques?: Caracteristique[];
  details?: Detail[];
}
