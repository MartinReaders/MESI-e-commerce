CREATE TABLE user (
  idUser INT(10) AUTO_INCREMENT,
  login VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  grade INT(5),
  lastName VARCHAR(30),
  firstName VARCHAR(30),
  email VARCHAR(50),
  phone VARCHAR(10),
  dateBirth Date,
  address1 VARCHAR(200),
  address2 VARCHAR(200),
  zipCode VARCHAR(10),
  city VARCHAR(100),
  country VARCHAR(30),
  PRIMARY KEY(idUser)
);

CREATE TABLE typeProduct (
  idTypeProduct INT(10) AUTO_INCREMENT,
  typeProduct VARCHAR(30),
  familyProduct VARCHAR(30),
  PRIMARY KEY (idTypeProduct)
);

CREATE TABLE statusProduct (
  idStatusProduct INT(10) AUTO_INCREMENT,
  statusProduct VARCHAR(30),
  PRIMARY KEY (idStatusProduct)
);

CREATE TABLE brand (
  idBrand INT(10) AUTO_INCREMENT,
  libelle VARCHAR(30),
  colorBrand VARCHAR(30),
  PRIMARY KEY (idBrand)
);


CREATE TABLE product (
  idProduct INT(10) AUTO_INCREMENT,
  idBrand INT(10) NOT NULL,
  model VARCHAR(100)NOT NULL,
  price INT(10) NOT NULL,
  image VARCHAR(150),
  quantity INT(10),
  idTypeProduct INT(10),
  idStatusProduct INT(10),
  description VARCHAR(5000),
  score INT(10),
  PRIMARY KEY (idProduct),
  FOREIGN KEY (idBrand) REFERENCES brand (idBrand),
  FOREIGN KEY (idTypeProduct) REFERENCES typeProduct (idTypeProduct),
  FOREIGN KEY (idStatusProduct) REFERENCES statusProduct (idStatusProduct)
);


CREATE TABLE characteristics (
  idcharacteristics INT(10) AUTO_INCREMENT,
  idTypeProduct INT(10),
  title VARCHAR(30),
  PRIMARY KEY (idCharacteristics),
  FOREIGN KEY (idTypeProduct) REFERENCES typeProduct (idTypeProduct)
);

# CREATE TABLE product_characteristics(
#   idProductCharacteristics INT(10) AUTO_INCREMENT,
#   idProduct INT(10) NOT NULL,
#   idCharacteristics INT(10) NOT NULL,
#   valeur VARCHAR(30),
#   PRIMARY KEY (idProductCharacteristics),
#   FOREIGN KEY (idProduct) REFERENCES product (idProduct),
#   FOREIGN KEY (idCharacteristics) REFERENCES characteristics (idCharacteristics)
# );


CREATE TABLE basket (
  idBasket INT(10) AUTO_INCREMENT,
  idUser INT(10) NOT NULL,
  createdBasket DATE,
  PRIMARY KEY (idBasket),
  FOREIGN KEY (idUser) REFERENCES user (idUser)
);

CREATE TABLE product_basket (
  idProductBasket INT(10) AUTO_INCREMENT,
  idProduct INT(10) NOT NULL,
  idBasket INT(10) NOT NULL,
  quantity INT(10),
  PRIMARY KEY (idProductBasket),
  FOREIGN KEY (idProduct) REFERENCES product (idProduct),
  FOREIGN KEY (idBasket) REFERENCES basket (idBasket)
);

CREATE TABLE allOrder (
  idOrder INT(10) AUTO_INCREMENT,
  idUser INT(10) NOT NULL,
  idBasket INT(10) NOT NULL,
  date DATE,
  totalPrice INT(15) NOT NULL,
  PRIMARY KEY (idOrder),
  FOREIGN KEY (idBasket) REFERENCES basket (idBasket)
);

CREATE TABLE score_user_product (
  idScoreUserProduct INT(10) AUTO_INCREMENT,
  idUser INT(10) NOT NULL,
  idProduct INT(10) NOT NULL,
  valeur TINYINT(1),
  PRIMARY KEY (idScoreUserProduct),
  FOREIGN KEY (idUser) REFERENCES user (idUser),
  FOREIGN KEY (idProduct) REFERENCES product (idProduct)
);
