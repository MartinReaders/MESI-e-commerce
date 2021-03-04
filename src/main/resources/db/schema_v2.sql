CREATE TABLE user (
  idUser INT(10) AUTO_INCREMENT,
  login VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  grade INT(5),
  lastName VARCHAR(30),
  firstName VARCHAR(30),
  email VARCHAR(50),
  phone INT(10),
  dateBirth Date,
  address1 VARCHAR(200),
  address2 VARCHAR(200),
  zipCode INT(10),
  city VARCHAR(100),
  country VARCHAR(30),
  PRIMARY KEY(idUser)
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
  idBasket INT(10) AUTO_INCREMENT,
  idUser INT(10) NOT NULL,
  idCard INT(10) NOT NULL,
  date DATE,
  totalPrice INT(15) NOT NULL,
  PRIMARY KEY (idBasket),
  FOREIGN KEY (idUser) REFERENCES user (idUser)
);