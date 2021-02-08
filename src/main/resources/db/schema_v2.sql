CREATE TABLE utilisateur (
  idUtilisateur INT(10) AUTO_INCREMENT,
  login VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  grade INT(5),
  nom VARCHAR(30),
  prenom VARCHAR(30),
  email VARCHAR(50),
  telephone INT(10),
  dateNaissance Date,
  adresse1 VARCHAR(200),
  adresse2 VARCHAR(200),
  codePostale INT(10),
  ville VARCHAR(100),
  pays VARCHAR(30),
  PRIMARY KEY(idUtilisateur)
);

CREATE TABLE product (
  idProduct INT(10) AUTO_INCREMENT,
  code VARCHAR(30) NOT NULL,
  brand VARCHAR(30) NOT NULL,
  model VARCHAR(100)NOT NULL,
  price INT(10) NOT NULL,
  image VARCHAR(150),
  quantity INT(10),
  type VARCHAR(30),
  color VARCHAR(30),
  colorBrand VARCHAR(30),
  description VARCHAR(5000),
  rgb BOOLEAN,
  PRIMARY KEY (idProduct)
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
  FOREIGN KEY (idProduit) REFERENCES product (idProduit),
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