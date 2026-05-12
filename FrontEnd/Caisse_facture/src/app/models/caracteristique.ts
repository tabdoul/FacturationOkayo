import { Article } from "./article";

export interface Caracteristique {
  article: Article;
    nom: string;
    prix?: number;
    tva?: number;
    date_fin: Date;
}
