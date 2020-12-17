CREATE TABLE utilisateur (
  idUtilisateur INT(10) AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  grade INT(5),
  PRIMARY KEY(idUtilisateur)
);

CREATE TABLE produit (
  idProduit INT(10) AUTO_INCREMENT,
  code INT(10) NOT NULL,
  marque VARCHAR(30) NOT NULL,
  modele VARCHAR(50)NOT NULL,
  prix INT(10) NOT NULL,
  image VARCHAR(100),
  quantite INT(10),
  type VARCHAR(30),
  PRIMARY KEY (idProduit)
);

CREATE TABLE panier (
  idPanier INT(10) AUTO_INCREMENT,
  idUtilisateur INT(10) NOT NULL,
  createdPanier DATE,
  PRIMARY KEY (idPanier),
  FOREIGN KEY (idUtilisateur) REFERENCES utilisateur (idUtilisateur)
);

CREATE TABLE produit_panier (
  idProduitPanier INT(10) AUTO_INCREMENT,
  idProduit INT(10) NOT NULL,
  idPanier INT(10) NOT NULL,
  quantite INT(10),
  PRIMARY KEY (idProduitPanier),
  FOREIGN KEY (idProduit) REFERENCES produit (idProduit),
  FOREIGN KEY (idPanier) REFERENCES panier (idPanier)
);

CREATE TABLE commande (
  idCommande INT(10) AUTO_INCREMENT,
  idUtilisateur INT(10) NOT NULL,
  idPanier INT(10) NOT NULL,
  dateCommande DATE,
  prixTotal INT(15) NOT NULL,
  PRIMARY KEY (idCommande),
  FOREIGN KEY (idUtilisateur) REFERENCES utilisateur (idUtilisateur)
);