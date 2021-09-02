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
  image VARCHAR(150),
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
  image VARCHAR(150),
  description VARCHAR(5000),
  PRIMARY KEY (idBrand)
);


CREATE TABLE product (
  idProduct INT(10) AUTO_INCREMENT,
  code VARCHAR (100),
  idBrand INT(10) NOT NULL,
  model VARCHAR(100)NOT NULL,
  price INT(10) NOT NULL,
  image VARCHAR(150),
  quantity INT(10),
  idTypeProduct INT(10),
  idStatusProduct INT(10),
  description VARCHAR(5000),
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

-- CREATE TABLE product_characteristics(
--     idProductCharacteristics INT(10) AUTO_INCREMENT,
--     idProduct INT(10) NOT NULL,
--     idCharacteristics INT(10) NOT NULL,
--     valeur VARCHAR(30),
--     PRIMARY KEY (idProductCharacteristics),
--     FOREIGN KEY (idProduct) REFERENCES product (idProduct),
--     FOREIGN KEY (idCharacteristics) REFERENCES characteristics (idCharacteristics)
-- );


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
  FOREIGN KEY (idBasket) REFERENCES basket (idBasket),
  FOREIGN KEY (idUser) REFERENCES user (idUser)
);

CREATE TABLE score_user_product (
  idScoreUserProduct INT(10) AUTO_INCREMENT,
  idUser INT(10) NOT NULL,
  idProduct INT(10) NOT NULL,
  PRIMARY KEY (idScoreUserProduct),
  FOREIGN KEY (idUser) REFERENCES user (idUser),
  FOREIGN KEY (idProduct) REFERENCES product (idProduct)
);


INSERT INTO user (idUser, login, password, grade, firstName, lastName, image) VALUES
(1, 'root','$2a$10$qSA1esFi8Y.1k5urAJcAV.rFPAodh8d2LcItKzeRzuHaJFhLjK1TO',1,'un Prenom','un Nom','img.png'),
(2, 'admin','$2a$10$qSA1esFi8Y.1k5urAJcAV.rFPAodh8d2LcItKzeRzuHaJFhLjK1TO',2,'un Prenom2','un Nom2','img.png'),
(3, 'Aa','$2a$10$qSA1esFi8Y.1k5urAJcAV.rFPAodh8d2LcItKzeRzuHaJFhLjK1TO',3,'un Prenom3','un Nom3','img.png');


INSERT INTO typeProduct (idTypeProduct, typeProduct, familyProduct) VALUES
(1,'souris','périphériques'),
(2,'enceinte','périphériques'),
(3,'chaise','périphériques'),
(4,'tapis de souris','périphériques'),
(5,'clavier','périphériques'),
(6,'processeur','composants');


INSERT INTO statusProduct (idStatusProduct, statusProduct) VALUES
(1,'en stock'),
(2,'hors stock'),
(3,'a venir');

INSERT INTO brand (idBrand, libelle, colorBrand, image, description) VALUES
(1,'Logitech','bleu','logitech/logo.png','desc'),
(2,'Corsair','jaune','Corsair/logo.png','desc'),
(3,'Millenium','violet','Millenium/logo.png','desc'),
(4,'SteelSeries','orange','SteelSeries/logo.png','desc'),
(5,'Razer','vert','Razer/logo.png','desc'),
(6,'Ducky Channel','jaune','Ducky_Channel/logo.png','desc'),
(7,'Aorus','argent','Aorus/logo.png','desc'),
(8,'Alienware','cyan','Alienware/logo.png','desc'),
(9,'AKRacing','rouge','AKRacing/logo.png','desc'),
(10,'DXRacer','blanc','DXRacer/logo.png','desc'),
(11,'Spirit of Gamer','noir','Spirit_of_Gamer/logo.png','desc'),
(12,'REKT','orange','REKT/logo.png','desc'),
(13,'Noblechairs','noir','Noblechairs/logo.svg','desc'),
(14,'Bose','argent','Bose/logo.png','desc'),
(15,'JBL','orange','JBL/logo.png','desc');

INSERT INTO product (code, idBrand, model, price, image, quantity, idTypeProduct, idStatusProduct, description) VALUES
('CLA-LOG',1,'G513 Carbone',139,'logitech/G513_Carbone.jpg',15,6,1,'Mélange parfait de performances, de technologies et d''une conception d''une qualité inégalée, le clavier G513 est un clavier gaming mécanique RVB équipé des switches mécaniques tactiles GX Brown plébiscités par les professionnels d''eSports du monde entier.'),
('CLA-LOG',1,'G PRO',160,'logitech/G_PRO.jpg',13,6,1,'Foncez vers la victoire avec ce clavier Logitech G Pro. Au format TKL (sans pavé numérique), il est spécialement adapté pour les tournois et les parties endiablées. Ce clavier gaming est équipé des switches mécaniques tactiles avancés GX Blue pour un retour audible et tactile.'),
('CLA-LOG',1,'G915 Lightspeed Carbone',249,'logitech/G915_Lightspeed_Carbone.jpg',12,6,1,'Rigoureusement conçu à partir de matériaux premium, le clavier Logitech G915 Lightspeed est doté d''un design sophistiqué, d''une robustesse à toute épreuve et de performances sans précédent. Équipé de la technologie sans fil Lightspeed, vous bénéficiez d''une réactivité extrêmement rapide.'),
('CLA-LOG',1,'G915 Tenkeyless Lightspeed Carbone',229,'logitech/G915_Tenkeyless_Lightspeed_Carbone.jpg',11,6,1,'Rigoureusement conçu à partir de matériaux premium, le clavier Logitech G915 TKL Lightspeed est doté d''un design sophistiqué, d''une robustesse à toute épreuve et de performances sans précédent. Équipé de la technologie sans fil Lightspeed, vous bénéficiez d''une réactivité extrêmement rapide.'),
('CLA-LOG',1,'G815 Carbone',199,'logitech/G815_Carbone.jpg',22,6,1,'Conçu pour des sessions de jeu hautes performances grâce à ses switches GL Tactile, le clavier Logitech G815 Carbone vous aidera à atteindre les sommets. Entièrement personnalisable, il est équipé de la technologie RGB Lightsync et de touches G dédiées.'),
('CLA-LOG',1,'G910 Orion Spectrum',179,'logitech/G910_Orion_Spectrum.jpg',2,6,1,'Avec le Logitech G910 Orion Spectrum RGB, vous bénéficiez du clavier mécanique le plus rapide du marché. Pour cela, il s''appuie sur des switchs mécaniques Romer-G qui offrent une réactivité inédite jusqu''à + 25% et une résistance accrue autorisant plus de 70 millions de frappes !'),
('CLA-LOG',1,'Craft',189,'logitech/Craft.jpg',3,6,1,'Unique en son genre, le clavier Bluetooth Logitech Craft vous offre une expérience de frappe unique et vous permettra d''exprimer pleinement votre créativité. Disposant d''une molette de contrôle contextuelle, cette dernière s''adapte à l''application que vous utilisez.'),
('CLA-COR',2,'K68',84,'Corsair/K68.jpg',4,6,1,'Le clavier mécanique CORSAIR K68 RGB va vous mener jusqu''à la victoire ! Doté de switches 100 % CHERRY MX Red et de la technologie 100 % anti-ghosting avec rollover complet, ce clavier gamer assure une frappe précise et réactive avec un rétroéclairage dynamique RGB.'),
('CLA-COR',2,'K55',70,'Corsair/K55.jpg',12,6,1,'Pour aligner les victoires et construire votre réputation, le clavier Corsair Gaming K55 RGB est le partenaire rêvé. Avec ses touches silencieuses et ses 6 touches macros, vous avez à votre disposition une surface de jeu idéale et performante.'),
('CLA-COR',2,'K57',109,'Corsair/K57.jpg',7,6,1,'Optez pour un clavier gaming polyvalent avec le Corsair K57 pour une expérience de jeu agréable au quotidien. interrupteurs à membrane silencieux et réactifs, mode de fonctionnement hybride (filaire ou sans fil) ainsi qu''un système RGB avancé sont de la partie !'),
('CLA-COR',2,'K100',270,'Corsair/K100.jpg',1,6,1,'Prenez le dessus sur vos adversaires grâce au clavier Corsair K100. Avec son design en aluminium, il offre une expérience de jeu agréable au quotidien. Il embarque notamment des switches optiques Corsair OPX ainsi qu''un rétroéclairage RGB par touche pour donner vie à votre clavier.'),
('CLA-COR',2,'K60',159,'Corsair/K60.jpg',2,6,1,'A la fois stylé et performant, le Corsair K60 RGB Pro est le clavier idéal pour foncer vers la victoire. Avec son design en aluminium, il offre une expérience de jeu agréable au quotidien. Il embarque notamment des switches Cherry Viola ainsi qu''un rétroéclairage RGB par touche.'),
('CLA-COR',2,'K83',129,'Corsair/K83.jpg',3,6,1,'Le clavier Corsair K83 Wireless AZERTY Noir vous permet d''accéder au meilleur du divertissement sans quitter votre canapé. Le K83 de Corsair propose un pavé tactile et un joystick pour une expérience intuitive et multi-supports grâce à sa compatibilité avec de nombreux systèmes d''exploitation.'),
('CLA-MIL',3,'Touch 2',62,'Millenium/Touch_2.jpg',7,6,1,'Le Touch 2 de Millenium est un clavier mécanique qui offre une frappe beaucoup plus rapide, sensible et précise afin de vous faire connaitre un plaisir de jeu incomparable. Il est doté d''interrupteurs mécaniques rouges qui peuvent supporter jusqu''à 50 millions de frappes.'),
('CLA-MIL',3,'Touch 2 Mini',59,'Millenium/Touch_2_Mini.jpg',9,6,1,'Le Touch 2 Mini de Millenium est un clavier mécanique compact qui offre une frappe beaucoup plus rapide, sensible et précise afin de vous faire connaitre un plaisir de jeu incomparable. Il est doté d''interrupteurs mécaniques rouges qui peuvent supporter jusqu''à 50 millions de frappes.'),
('CLA-STE',4,'Apex Pro TKL',239,'SteelSeries/Apex_Pro_TKL.jpg',16,6,1,'Véritable bond en avant, le clavier SteelSeries Apex Pro TKL vous permet de régler chaque touche en fonction de votre niveau de sensibilité préféré, que ce soit pour le gaming, le travail ou autre chose. Plus rapide et résistant que jamais, il sera l''arme ultime pour remporter des victoires.'),
('CLA-STE',4,'Apex Pro',259,'SteelSeries/Apex_Pro.jpg',12,6,1,'Véritable bond en avant, le clavier SteelSeries Apex Pro vous permet de régler chaque touche en fonction de votre niveau de sensibilité préféré, que ce soit pour le gaming, le travail ou autre chose. Plus rapide et résistant que jamais, il sera l''arme ultime pour remporter des victoires.'),
('CLA-STE',4,'Apex 7 TKL',179,'SteelSeries/Apex_7_TKL.jpg',5,6,1,'Arborant un look moderne et élégant grâce à sa structure en aluminium, le SteelSeries Apex 7 deviendra la pièce centrale de votre installation gaming. Optimisé pour le jeu, il est doté des switches SteelSeries QX2 qui pourront subir jusqu''à 50 millions de pressions.'),
('CLA-STE',4,'Apex 5',149,'SteelSeries/Apex_5.jpg',8,6,1,'Proposant des caractéristiques premium, le SteelSeries Apex 5 vous aide à prendre le dessus sur vos adversaires. Équipé de switches mécaniques hybrides, il offre des performances inégalées pour faire de vous le numéro un.'),
('CLA-STE',4,'Apex 3',89,'SteelSeries/Apex_3.jpg',4,6,1,'Profitez de performances garanties grâce au SteelSeries Apex 3. Doté d''interrupteurs à membranes à friction réduite, il vous offre une utilisation sans bruit et une durabilité accrue. De plus, avec son rétroéclairage Prism RGB sur 10 zones, donnez vie à votre clavier.'),
('CLA-RAZ',5,'Blackwidow V3 TKL',119,'Razer/Blackwidow_V3_TKL.jpg',2,6,1,'Conçu spécifiquement pour le jeu, le Razer BlackWidow V3 TKL est un clavier compact armé de switches Razer Green afin de vous offrir une exécution précise avec une sensation tactile. Prenez ainsi facilement le dessus sur vos adversaires lors de duels.'),
('CLA-RAZ',5,'Blackwidow V3 PRO',254,'Razer/Blackwidow_V3_PRO.jpg',11,6,1,'Conçu spécifiquement pour le jeu, le Razer BlackWidow V3 Pro dispose de 3 modes de connexion pour une polyvalence inégalée. Pouvant se connecter via RF 2,4 GHz, Bluetooth 5.0 ou en mode filaire, il vous fait vivre une incroyable expérience de jeu grâce notamment à ses switches Razer Green.'),
('CLA-RAZ',5,'Blackwidow V3',159,'Razer/Blackwidow_V3.jpg',7,6,1,'Conçu spécifiquement pour le jeu, le Razer BlackWidow V3 est un clavier compact armé de switches Razer Green afin de vous offrir une exécution précise avec une sensation tactile. Prenez ainsi facilement le dessus sur vos adversaires lors de duels.'),
('CLA-RAZ',5,'Huntsman Elite',239,'Razer/Huntsman_Elite.jpg',8,6,1,'Le clavier pour gamer Razer Huntsman Elite est équipé des meilleurs composants que vous pouvez trouver dans un clavier. Ne laissez plus jamais un adversaire prendre le dessus grâce aux touches opto-mécaniques Razer.'),
('CLA-RAZ',5,'Huntsman',164,'Razer/Huntsman.jpg',6,6,1,'Ne laissez plus jamais un adversaire s''échapper avec le Razer Huntsman. Ce clavier gamer révolutionnera votre façon de jouer grâce aux touches opto-mécaniques Razer. Ces dernières disposent d''un capteur de lumière optique intégré qui actionne instantanément la order de la touche.'),
('CLA-DUC',6,'One 2 Mini',119,'Ducky_Channel/One_2_Mini.jpg',5,6,1,'60% plus compact que la version classique, le Ducky Channel One 2 Mini RGB dispose de tous les avantages d''une clavier traditionnel le tout dans un format réduit. Ce clavier gamer vous promet la victoire et vous offre notamment une prise en main idéale pour cela.'),
('CLA-DUC',6,'Mecha Mini (Cherry MX RGB Black)',159,'Ducky_Channel/Mecha_Mini_Cherry_Black.jpg',5,6,1,'Conçu pour vous offrir la meilleure expérience en termes de durabilité et de frappe, le Ducky Channel Mecha Mini ne laisse personne indifférent. Ce clavier gamer vous met dans les conditions idéales pour décrocher de nombreuses victoires et vous offre notamment une prise en main idéale pour cela.'),
('CLA-DUC',6,'One 2 SF RGB (Cherry MX RGB Speed Silver)',139,'Ducky_Channel/One_2_SF_Cherry_Speed_Silver.jpg',5,6,1,'Meilleure arme pour le succès, le clavier Ducky Channel One 2 SF deviendra vite indispensable à votre carrière de joueur. Avec son format compact réduit à 65%, il dit adieu au surplus des autres claviers en gardant uniquement l''essentiel pour vous permettre de remporter de nombreuses batailles.'),
('CLA-DUC',6,'MIYA Pro Moonlight (Cherry MX Black)',139,'Ducky_Channel/MIYA_Pro_Moonlight_Cherry_Black.jpg',5,6,1,'Douceur et efficacité, voici des mots qui caractérisent parfaitement le clavier Ducky Channel MIYA Pro Moonlight. Son design gris accueille des touches PBT résistantes et durables, un rétroéclairage blanc et des switches Cherry MX Black.'),
('CLA-DUC',6,'One 2 Backlit (coloris blanc - Cherry MX Blue - LEDs blanches)',139,'Ducky_Channel/One_2_Backlit_Cherry_Blue.jpg',5,6,1,'Le clavier mécanique Ducky Channel One 2 Backlit vous propose une qualité supérieure pour remporter de précieuses victoires. Il se pare de switches Cherry MX Blue, de touches PBT résistantes et durables et d''un rétro-éclairage blanc personnalisable.'),
('CLA-DUC',6,'One 2 Horizon (Cherry MX Brown)',119,'Ducky_Channel/One_2_Horizon_Cherry_Brown.jpg',5,6,1,'Equipez-vous avec un clavier mécanique des plus performants pour jouer la victoire. Le clavier Ducky Channel One 2 Horizon vous proposera un confort de jeu supérieur avec ses touches PBT, ses switches Cherry MX Brown et son système anti-ghosting N-Key Rollover.'),
('CLA-DUC',6,'One 2 Mini RGB Blanc (Cherry MX RGB Black)',119,'Ducky_Channel/One_2_Mini_RGB_Blanc_Cherry_Black.jpg',5,6,1,'60% plus compact que la version classique, le Ducky Channel One 2 Mini RGB dispose de tous les avantages d''une clavier traditionnel le tout dans un format réduit. Ce clavier gamer vous promet la victoire et vous offre notamment une prise en main idéale pour cela.'),
('CLA-DUC',7,'K1 (Cherry MX Red)',109,'Aorus/K1.jpg',4,6,1,'Gagnez en confort et soutenez vos performances de jeu avec le clavier mécanique AORUS K1. Grâce à ses interrupteurs mécaniques Cherry MX Red, le clavier est très réactif et réduit également les nuisances sonores.'),
('CLA-DUC',7,'K9 Optical (Flaretech Red)',1799,'Aorus/K9.jpg',5,6,1,'Véritable arme destructrice, le Aorus K9 Optical vous aidera à faire qu''une bouchée de vos adversaires. En effet, ce clavier est équipé de switches optiques Flaretech qui offrent un temps de réponse inférieur à 0,3 ms afin d''être plus réactif que jamais.'),
('SOU-ALI',8,'310M',79,'Alienware/310M.jpg',7,2,1,'La souris de jeu Alienware 310M a été conçue pour une utilisation intensive et propose une conception robuste ainsi que d''excellente performances en alliant un capteur optique de 12 000 DPI à une autonomie maximale de 300 heures !'),
('SOU-ALI',8,'510M',99,'Alienware/510M.jpg',12,2,1,'La souris Alienware 510M est un redoutable instrument de précision, prêt à vous faire entrer dans une nouvelle ère de performances. Armée d''un capteur optique Alienware 16 000 DPI et de 10 boutons personnalisables à volonté, elle s''adapte à tous les jeux et à tous les styles : à vous la victoire !'),
('SOU-ALI',8,'610M',109,'Alienware/610M_Dark_Side_Of_The_Moon.jpg',15,2,1,'Que vous soyez confortablement installé chez vous ou bien en déplacement, la souris Alienware 610M ne vous laissera pas tomber. En effet, elle dispose à la fois d''un mode filaire USB et d''une batterie lithium-ion haute autonomie pour une utilisation sans fil sur une durée allant jusqu''à 350 heures !'),
('SOU-ALI',8,'610M',109,'Alienware/610M_Lunar_Light.jpg',15,2,1,'Que vous soyez confortablement installé chez vous ou bien en déplacement, la souris Alienware 610M ne vous laissera pas tomber. En effet, elle dispose à la fois d''un mode filaire USB et d''une batterie lithium-ion haute autonomie pour une utilisation sans fil sur une durée allant jusqu''à 350 heures !'),
('SOU-ALI',8,'AW959',99,'Alienware/AW959.jpg',7,2,1,'Redoutable en jeu, la souris Alienware Elite AW959 offre une réactivité exceptionnelle pour les jeux de tirs ou tous les gameplay qui demandent de la précision. Équipée d''un capteur optique de 12000 dpi, la souris AW959 transmet chaque mouvement avec une précision et une réactivité optimales.'),
('SOU-AOR',7,'M2',24,'Aorus/M2.jpg',3,2,1,'Visez les sommets avec la souris optique Aorus M2 ! Ce modèle ambidextre dispose d''une conception légère, d''un capteur optique 6200 dpi et de 7 boutons programmables. Un rétro-éclairage RGB est également disponible sur le logo pour créer un style qui vous ressemble.'),
('SOU-AOR',7,'M3',59,'Aorus/M3.jpg',2,2,1,'La Aorus M3 est une souris filaire qui dispose d''une conception légère, d''un capteur optique 6400 dpi et de 7 boutons programmables. Un rétroéclairage RGB est également disponible sur le logo pour créer un style qui vous ressemble.'),
('SOU-AOR',7,'M4',64,'Aorus/M4.jpg',4,2,1,'Ambidextre, la souris filaire Aorus M4 convient parfaitement aux droitiers comme aux gauchers. Embarquant un capteur optique de 6400 dpi ainsi que 8 boutons programmables, vous disposez d''une arme redoutable pour remporter de précieuses victoires. '),
('SOU-AOR',7,'M5',79,'Aorus/M5.jpg',13,2,1,'Vivez des parties intenses grâce à la souris pour gamer Aorus M5 et son capteur laser 16000 dpi. Disposant également de 7 boutons, d''un poids ajustable et d''un rétro-éclairage RGB, la M5 vous assure un maximum de flexibilité de personnalisation afin que la souris et votre main ne fassent qu''un.'),
('SOU-LOG',1,'G Pro HERO',79,'Logitech/G_Pro_HERO.jpg',19,2,1,'Profitez d''une vitesse et une précision exceptionnelles avec la souris Logitech G Pro HERO. Spécialement conçue pour l''eSport, elle intègre un capteur optique Hero de 16 000 dpi pour que chaque mouvement puisse faire mouche.'),
('SOU-LOG',1,'G Pro Wireless',129,'Logitech/G_Pro_Wireless.jpg',13,2,1,'Avec la Logitech G Pro Wireless Gaming Mouse, Logitech s''est associé aux joueurs d''eSports afin de concevoir la souris idéale pour les tournois. Avec une conception classique mais ergonomique, elle intègre un capteur optique Hero 16K qui offre un suivi d''une précision exceptionnelle.'),
('SOU-LOG',1,'G203 LightSync',39,'Logitech/G203_LightSync.jpg',6,2,1,'Avec une conception classique et des lignes simples, la Logitech G203 LightSync offre des performances conformes aux exigences des jeux vidéo en garantissant une réponse quasi instantanée aux mouvements et aux clics.'),
('SOU-LOG',1,'G305 Lightspeed Wireless',59,'Logitech/G305_Lightspeed_Wireless.jpg',7,2,1,'Profitez d''une expérience sans fil incroyable grâce à la technologie sans fil Lightspeed de la Logitech G305 Lightspeed Wireless Gaming Mouse. En effet, cette dernière vous offre des performances sans fil de niveau professionnel et une fiabilité inégalée.'),
('SOU-LOG',1,'G502 Lightspeed',139,'Logitech/G502_Lightspeed.jpg',24,2,1,'Disposant d''une conception sans fil avec technologie Lightspeed, la Logitech G502 Lightspeed fera de vous une machine redoutable et redoutée. En effet, elle est équipée d''un capteur optique HERO de 16000 dpi pour une précision et une réactivité optimale.'),
('SOU-LOG',1,'G502',60,'logitech/G502.jpg',16,2,1,'Conçue pour vous offrir des niveaux de personnalisation inégalés, la Logitech G502 Hero fera de vous une machine redoutable et redoutée. En effet, elle est équipée d''un capteur optique de 16000 dpi pour une précision et une réactivité optimale.'),
('SOU-LOG',1,'G903 Lightspeed Hero Wireless',149,'Logitech/G903_Lightspeed_Hero_Wireless.jpg',32,2,1,'Extrêmement efficace, la Logitech G903 Lightspeed Hero Wireless Gaming Mouse offre une réactivité exceptionnelle pour les tirs de précision en compétition. Équipée du capteur optique Hero de 16000 dpi, la souris G903 transmet chaque mouvement, et ce, avec une précision et une réactivité optimales.'),
('SOU-LOG',1,'Gaming Pro X Wireless Superlight',149,'Logitech/Gaming_Pro_X__Wireless_Superlight_blanc.jpg',13,2,1,'Foncez vers la victoire grâce à la souris Logitech Wireless Gaming Pro X Superlight. Nouvelle arme de prédilection des meilleurs athlètes professionnels d''eSports, elle pèse moins de 63 grammes et offre un glissement sans l moindre friction.'),
('SOU-LOG',1,'Gaming Pro X Wireless Superlight',149,'Logitech/Gaming_Pro_X__Wireless_Superlight_noir.jpg',14,2,1,'Foncez vers la victoire grâce à la souris Logitech Wireless Gaming Pro X Superlight. Nouvelle arme de prédilection des meilleurs athlètes professionnels d''eSports, elle pèse moins de 63 grammes et offre un glissement sans l moindre friction.'),
('SOU-RAZ',5,'Naga Pro',172,'Razer/Naga_Pro.jpg',6,2,1,'Quel que soit le jeu auquel vous jouez, la souris Razer Naga Pro apporte toute l''ergonomie et l''esthétique attendue d''un gamer ! Elle vous permet de configurer votre souris pour tout, que ce soit pour utiliser des armes ou créer des personnalisations, afin que vous écrasiez toujours la concurrence.'),
('SOU-RAZ',5,'Naga Trinity',114,'Razer/Naga_Trinity.jpg',4,2,1,'Quel que soit le jeu auquel vous jouez, la souris Razer Naga Trinity apporte toute l''ergonomie et l''esthétique attendue d''un gamer ! Elle vous permet de configurer votre souris pour tout, que ce soit pour utiliser des armes ou créer des personnalisations, afin que vous écrasiez toujours la concurrence.'),
('SOU-RAZ',5,'Basilisk X HyperSpeed',59,'Razer/Basilisk_X_HyperSpeed.jpg',12,2,1,'Quel que soit le type de jeu ou encore votre style de jeu, la Razer Basilisk X HyperSpeed répond toujours présente. Sans fil, cette souris dispose de deux modes de fonctionnement pour vous garantir une liberté incroyable.'),
('SOU-RAZ',5,'Deathadder v2',84,'Razer/Deathadder_v2.jpg',7,2,1,'Avec la souris Razer DeathAdder v2, offrez-vous une arme redoutable pour venir à bout des plus coriaces adversaires. En effet, elle intègre un capteur optique Razer Focus + de 20000 dpi afin de vous offrir une précision inégalée.'),
('SOU-RAZ',5,'Deathadder v2 Pro',159,'Razer/Deathadder_v2_Pro.jpg',3,2,1,'Venez à bout des adversaires les plus coriaces avec la souris Razer DeathAdder v2 Pro et sa double connectivité sans fil RF 2.4 GHz/Bluetooth 5.0. Offrant une totale liberté de mouvement et de contrôle, elle intègre un capteur optique Razer Focus+ de 20000 dpi et 8 boutons programmables.'),
('SOU-RAZ',5,'Pro Click',114,'Razer/Pro_Click.jpg',4,2,1,'Conçue en collaboration avec les experts mondiaux en ergonomie bureautique Humanscale, la Razer Pro Click vous offre un confort d''utilisation incroyable. En effet, elle soutient mieux votre paume et empêche votre poignet de peser sur la surface où vous travaillez, soulageant la douleur.'),
('SOU-STE',4,'Aerox 3 Wireless',109,'SteelSeries/Aerox_3_Wireless.jpg',7,2,1,'Ultralégère, la souris SteelSeries Aerox 3 Wireless permet un maniement sans effort pendant 200 heures d''utilisation. Équipée d''un capteur optique exclusif TrueMove Air de 18000 dpi et d''une double connexion sans fil Bluetooth/RF 2.4 GHz, elle offre une vitesse et une précision incroyables.'),
('SOU-STE',4,'Aerox 3',69,'SteelSeries/Aerox_3.jpg',12,2,1,'Ultralégère, la souris SteelSeries Aerox 3 permet un maniement sans effort. Équipée d''un capteur optique exclusif TrueMove Core de 8500 dpi, et de patins en PTFE, elle offre une vitesse et une précision incroyable pour améliorer votre expérience de jeu.'),
('SOU-STE',4,'Rival 710',99,'SteelSeries/Rival_710.jpg',11,2,1,'Accédez à un niveau de performance jamais atteint avec la SteelSeries Rival 710. Équipée du capteur optique exclusif TrueMove3, la distance parcourue sur votre tapis de souris sera la même réalisée à l''écran et sans latence ni interpolation.'),
('SOU-STE',4,'Sensei 310',54,'SteelSeries/Sensei_310.jpg',8,2,1,'La souris SteelSeries Sensei 310 propose une expérience eSport totale grâce à son capteur optique 12 000 dpi TrueMove3. Performant et précis, il assure un suivi 1:1 sans latence pour une efficacité redoutable. Profitez d''un design ambidextre, de 8 boutons programmables et d''un rétro-éclairage RGB.'),
('SOU-STE',4,'Rival 310',54,'SteelSeries/Rival_310.jpg',9,2,1,'Vivez des moments intenses avec la souris SteelSeries Rival 310. Digne représentante de l''eSport, elle embarque un capteur optique TrueMove3 pour un suivi 1:1 précis sans latence. Profitez d''une sensibilité jusqu''à 12 000 dpi, de 6 boutons programmables et d''un rétro-éclairage RGB sur 2 zones.'),
('SOU-MIL',3,'Optic 1 Advanced',39,'Millenium/Optic_1_Advanced.jpg',28,2,1,'Version améliorée de la Millenium Optic 1, la Millenium Optic 1 Advanced vous permet d''augmenter votre vitesse et votre précision grâce à son capteur optique allant jusqu''à 8000 dpi. Complété d''une fréquence d''envoi 1000 Hz, bénéficiez d''une réactivité accrue.'),
('SOU-MIL',3,'Optic 1',19,'Millenium/Optic_1.jpg',16,2,1,'Excellez dans les jeux qui requièrent une rapidité et une précision sans faille avec la Millenium Optic 1. Cette souris pour gamer est dotée d''un capteur optique allant jusqu''à 4000 dpi pour un déplacement rapide et précis en jeu'),
('SOU-COR',2,'Dark Core Pro',109,'Corsair/Dark_Core_Pro.jpg',12,2,1,'Proposant une connexion filaire (USB) et non filaire (Bluetooth/RF), la souris Dark Core RGB Pro de Corsair vous donne un avantage certain sur tous vos adversaires. Équipée d''un capteur optique de 18 000 dpi, elle offre des performances de gaming exceptionnelles.'),
('SOU-COR',2,'Gaming Scimitar Elite',99,'Corsair/Gaming_Scimitar_Elite.jpg',9,2,1,'Foncez vers la victoire avec la Corsair Gaming Scimitar RGB Elite. Cette souris dispose de 17 boutons programmables ainsi qu''un capteur optique de 18 000 dpi afin de vous permettre de terrasser vos adversaires sur les jeux MOBA et MMO.'),
('SOU-COR',2,'Glaive PRO',89,'Corsair/Glaive_PRO.jpg',12,2,1,'Jouez dans la cour des grands aux commandes de la souris Corsair Glaive RGB Pro et atteignez vos objectifs en toute maîtrise ! Profitez d''un confort supérieur avec grip interchangeable et d''une performance professionnelle avec un capteur optique 18 000 dpi ajustable et 7 boutons programmables.'),
('SOU-COR',2,'Ironclaw Wireless',89,'Corsair/Ironclaw_Wireless.jpg',15,2,1,'Réussissez votre quête et atteignez vos objectifs avec la souris Corsair Ironclaw RGB Wireless dans votre arsenal. Alliant parfaitement performances, confort et personnalisation, ce modèle vous mènera directement vers la victoire pour un futur qui s''annonce grandiose !'),
('SOU-COR',2,'Gaming Nightsword',89,'Corsair/Gaming_Nightsword.jpg',13,2,1,'8 boutons programmables, éclairage LED RGB  4 zones, poids ajustable de 119 gr à 141 gr et sensibilité réglable au DPI près, la Corsair Nightsword RGB vous permettra de relever tous les défis en s''adaptant à votre style de jeu.'),
('SOU-COR',2,'Gaming M65 Pro',74,'Corsair/Gaming_M65_Pro.jpg',9,2,1,'Aux commandes de votre souris optique Corsair Gaming M65 Pro RGB, vous allez pouvoir mettre toutes les chances de votre côté. Dotée d''un capteur optique de 12000 DPI, d''un bouton sniper et de trois zones d''éclairage personnalisables, cette souris sera un partenaire redoutable !'),
('SOU-COR',2,'Gaming M65 Elite',74,'Corsair/Gaming_M65_Elite.jpg',12,2,1,'Aux commandes de votre souris optique Corsair Gaming M65 RGB Elite, vous allez pouvoir mettre toutes les chances de votre côté. Dotée d''un capteur optique de 18000 DPI, d''un bouton sniper et de deux zones d''éclairage personnalisables, cette souris sera un partenaire redoutable !'),
('CHA-AKR',9,'Core EX',249,'AKRacing/Core_EX.jpg',23,4,1,'Parfait pour les soutiens aux lombaires, le siège AKRacing Core EX vous permettra d''oublier les problèmes liés à une mauvaise posture. En effet, la courbe ergonomique du siège suit naturellement la courbe du bas du dos.'),
('CHA-AKR',9,'Core LX Plus',349,'AKRacing/Core_LX_Plus.jpg',12,4,1,'Avec le AKRacing Core LX Plus, vous disposez d''un confort toujours plus important. Le LX Plus offre le meilleur confort de la gamme Core et est un mélange de design futuriste et de courbes douces. Et avec sa mousse durcie à froid, il offre un confort indéniable, même pendant de longues heures.'),
('CHA-AKR',9,'Core EX',249,'AKRacing/Core_EX_noir_rouge.jpg',2,4,1,'Parfait pour les soutiens aux lombaires, le siège AKRacing Core EX vous permettra d''oublier les problèmes liés à une mauvaise posture. En effet, la courbe ergonomique du siège suit naturellement la courbe du bas du dos.'),
('CHA-AKR',9,'Onyx',399,'AKRacing/Onyx.jpg',14,4,1,'Le AKRacing Onyx est un siège en similicuir qui offre une ergonomie avancée afin de vous offrir la meilleure des positions. Inclinable à 180°, il est également capable de soutenir jusqu''à 150 kg.'),
('CHA-AKR',9,'California',349,'AKRacing/California.jpg',12,4,1,'Inspiré par le célèbre État américain, le fauteuil AKRacing California est idéal pour les personnes à petits gabarits ou les silhouettes menues. Tout en couleur, il vous permet de trouver votre posture idéale afin de ne pas subir de mal de dos.'),
('CHA-AKR',9,'Onyx Deluxe',499,'AKRacing/Onyx_Deluxe.jpg',21,4,1,'La Onyx Deluxe est la première chaise en cuir véritable d''AKRacing. Son nouveau cadre en métal toujours plus résistant vous garantira une ergonomie et un confort maximum. Inclinable à 180°, il est également capable de soutenir jusqu''à 150 kg.'),
('CHA-AKR',9,'Pro Deluxe',649,'AKRacing/Pro_Deluxe.jpg',11,4,1,'Avec son design sobre et raffiné, le AKRacing Pro Deluxe ne laisse personne indifférent. Offrant un confort à toute épreuve, il est à l''aise dans tous les domaines, que ce soit pour des sessions de jeu, de travail ou des moments détentes, il répond toujours présent.'),
('CHA-DXR',10,'Formula F11',299,'DXRacer/Formula_F11.jpg',6,4,1,'La majorité de sièges de bureau en vente ont des dossiers bas ce qui ne permet pas de soutenir votre cou. Le fauteuil de bureau DXRacer Formula F11 a surmonté ce problème avec succès. Il vous permet de retenir un angle assis aux hanches de 90 degrés.'),
('CHA-DXR',10,'Formula F08',299,'DXRacer/Formula_F08.jpg',4,4,1,'Le siège gaming DXRacer Formula F08 offre aux joueurs une position idéale avec un design haut, un dossier inclinable, des accoudoirs 3D et la possibilité de régler la hauteur. Sa finition élégante en similicuir associe confort et esthétisme pour le plus grand plaisir des gamers.'),
('CHA-DXR',10,'Tank T29',499,'DXRacer/Tank_T29.jpg',8,4,1,'En proposant un confort supérieur, le siège gamer DXRacer Tank T29 vous accompagne idéalement dans votre quête de la victoire. Base en aluminium associé à un revêtement en similicuir, accoudoirs 4D, dossier inclinable jusqu''à 120° et charge maximale de 150 kg, les qualités sont au rendez-vous !'),
('CHA-SOG',11,'Demon',229,'Spirit_of_Gamer/Demon.jpg',12,4,1,'Installez-vous confortablement devant votre ordinateur dans le siège Spirit of Gamer Demon avec son assise agréable, son revêtement similicuir et ses accoudoirs 2D. Élégant avec son coloris noir et rouge et son design baquet, il offre une position idéale pour affronter les longues sessions gaming.'),
('CHA-REK',12,'RGo Max Business',749,'REKT/RGo_Max_Business.jpg',3,4,1,'Avec son design élégant et sobre, le fauteuil REKT RGo Max Business répond parfaitement à tous vos besoins. Sa conception ergonomique offre une position optimale pour minimiser les douleurs et vous apporter un confort permanent au quotidien.'),
('CHA-NOB',13,'Epic',399,'Noblechairs/Epic.jpg',9,4,1,'En similicuir, le Noblechairs Epic est un siège pour gamer inclinable jusqu''à 135°, et capable de soutenir jusqu''à 120 kg. Il est orné d''un motif en losange qui va permettre une aération optimale du siège même en été.'),
('CHA-NOB',13,'Hero Cuir',699,'Noblechairs/Hero_Cuir.jpg',4,4,1,'Avec son siège HERO, Noblechairs propose à tous les joueurs d''adopter une position de jeu idéale en profitant de multiples possibilités de réglages avancés. Ce fauteuil de jeu pensé en étroite collaboration avec des professionnels de l''esport se veut haut de gamme.'),
('CHA-NOB',13,'Icon Cuir',699,'Noblechairs/Icon_Cuir.jpg',3,4,1,'Directement inspiré de la Porsche 911, le siège en cuir Icon Cuir de Noblechairs vous offrira une assise confortable. Réglable en plusieurs points, vous allez notamment pouvoir l''incliner jusqu''à 135° ou modifier horizontalement et verticalement vos accoudoirs'),
('CHA-COR',2,'T1 Race V2 (noir/blanc)',499,'Corsair/T1_Race_V2_noir_blanc.jpg',2,4,1,'Avec un design inspiré des sports automobiles et conçu à l''aide de matériaux de haute qualité, le siège Corsair T1 Race sera l''allié idéal dans tous vos jeux et vos parties les plus intenses pour une expérience de jeu professionnelle.'),
('CHA-COR',2,'T1 Race V2 (noir/bleu)',499,'Corsair/T1_Race_V2_noir_bleu.jpg',6,4,1,'Avec un design inspiré des sports automobiles et conçu à l''aide de matériaux de haute qualité, le siège Corsair T1 Race sera l''allié idéal dans tous vos jeux et vos parties les plus intenses pour une expérience de jeu professionnelle.'),
('CHA-COR',2,'T2 Road Warrior (noir/blanc)',599,'Corsair/T2_Road_Warrior_noir_blanc.jpg',8,4,1,'Avec un design inspiré des sports automobiles et conçu à l''aide de matériaux de haute qualité, le siège Corsair T2 Road Warrior sera l''allié idéal dans tous vos jeux et vos parties les plus intenses pour une expérience de jeu professionnelle.'),
('CHA-COR',2,'T2 Road Warrior (noir/jaune)',599,'Corsair/T2_Road_Warrior_noir_jaune.jpg',9,4,1,'Avec un design inspiré des sports automobiles et conçu à l''aide de matériaux de haute qualité, le siège Corsair T2 Road Warrior sera l''allié idéal dans tous vos jeux et vos parties les plus intenses pour une expérience de jeu professionnelle.'),
('CHA-COR',2,'T2 Road Warrior (noir/bleu)',599,'Corsair/T2_Road_Warrior_noir_bleu.jpg',6,4,1,'Avec un design inspiré des sports automobiles et conçu à l''aide de matériaux de haute qualité, le siège Corsair T2 Road Warrior sera l''allié idéal dans tous vos jeux et vos parties les plus intenses pour une expérience de jeu professionnelle.'),
('CHA-MIL',3,'Chair',299,'Millenium/Chair.jpg',3,4,1,'Excellent choix pour jouer confortablement et avec style pendant des heures, le siège Millenium Chair deviendra vite indispensable à vos sessions de gaming. Avec son design sobre et élégant, vous pourrez en faire votre compagnon de bureau sans dénaturer votre intérieur.'),
('CHA-RAZ',5,'Iskur',549,'Razer/Iskur.jpg',3,4,1,'Conçu spécialement pour les longues sessions de jeu, le siège Razer Iskur vous permet de conserver une posture parfaite. Entièrement réglable, vous allez pouvoir notamment trouver une posture en fonction de votre activité.'),
('CHA-RAZ',7,'GC300',399,'Aorus/GC300.jpg',3,4,1,'Les succès ne sont jamais garantis, mais vous pouvez multiplier vos chances de réussite grâce au sublime fauteuil GC300 d''AORUS. En effet, ergonomique, robuste et ultra confortable, ce fauteuil vous met dans les meilleures conditions et dispositions pour faire face à toutes les confrontations.'),
('ENC-BOS',14,'Companion 50',399,'Bose/Companion_50.jpg',12,3,1,'Le système Bose à trois enceintes d''ordinateur délivre un son multicanal qui semble vous envelopper, sans l''encombrement d''une installation à cinq enceintes et prend en charge les musiques, jeux et films encodés en 5.1.'),
('ENC-BOS',14,'Companion 20',276,'Bose/Companion_20.jpg',9,3,1,'Optimisez les performances audio de votre ordinateur avec le système d''enceintes multimédia Companion® 20. Ce système à deux enceintes le plus performant vous offre un son riche et naturel, que vous soyez devant votre ordinateur ou de l''autre côté de la pièce.'),
('ENC-BOS',14,'Companion 2 Serie 3',99,'Bose/Companion_2_Serie_3.jpg',16,3,1,'Vous aimez écouter de la musique, jouer à des jeux vidéo et regarder des films sur votre ordinateur ? Essayez le système d''enceintes multimédia Companion® 2 Série III. Vous profiterez de performances résolument supérieures à celles de vos enceintes d''origine, à un prix très abordable.'),
('ENC-JBL',15,'Quantum Duo',149,'JBL/Quantum_Duo.jpg',2,3,1,'Le savoir-faire acoustique JBL pointe le bout de son nez dans l''univers gaming et présente ses enceintes PC Quantum Duo. Portées par un son immersif, réaliste et précis, elles vous plongeront directement au coeur de l''action. Découvrez également un éclairage RGB personnalisable et synchronisable.'),
('ENC-LOG',1,'G560',255,'logitech/G560.jpg',13,3,1,'Découvrez une nouvelle façon d''entendre vos jeux grâce au kit d''enceintes multimédia Logitech G560. En effet, le kit est doté de la technologie Lightsync afin de vous plonger au coeur de l''action.'),
('ENC-LOG',1,'Z533',93,'logitech/Z533.jpg',10,3,1,'Avec une puissance RMS de 60 watts (pouvant atteindre les 120 watts en puissance de crête), le système de haut-parleurs multimédia Logitech Multimedia Speakers System Z533 offre un son puissant avec des basses améliorées et des aigus précis pour un son riche, ample et puissant.'),
('ENC-LOG',1,'Z200',39,'logitech/Z200.jpg',15,3,1,'Avec une puissance de crête de 10 watts (5 Watts RMS), les haut-parleurs Logitech Z200 Multimedia Speakers au design moderne offrent un son riche et clair. Deux transducteurs par haut-parleur génèrent un son stéréo équilibré et une acoustique impeccable pour une immersion sonore totale.'),
('ENC-LOG',1,'Z625',199,'logitech/Z625.jpg',12,3,1,'Le système 2.1 Logitech Z625 Powerful THX Sound product un son grandiose d''une puissance de 200 watts (130 watts RMS pour le caisson de graves et 2 x 35 watts RMS pour les satellites), certifié THX. Profitez d''un son qui rendra votre musique, vos films et vos jeux encore plus vivants.'),
('ENC-LOG',1,'Z407',89,'logitech/Z407.jpg',6,3,1,'Avec l''ensemble Logitech Z407, profitez d''un son immersif et réaliste. En effet, avec une puissance de 40W RMS associée à un traitement numérique du signal (DSP), vous obtenez des aigus cristallins et des graves puissants pour une immersion totale.'),
('ENC-LOG',1,'Z333',67,'logitech/Z333.jpg',7,3,1,'Avec ses 40 watts RMS, le système Logitech Multimedia Speakers Z333 offre un son puissant, immersif, net, clair et équilibré. Le caisson de basses situé à l''avant dispose d''un transducteur de 5" pour une réponse des basses profonde.'),
('ENC-LOG',1,'Z906',349,'logitech/Z906.jpg',1,3,1,'Avec une puissance de diffusion de 500 watts (RMS), ce système 5.1 certifié THX product un son de qualité cinéma. Profitez d''un contrôle total sur votre système multimédia grâce à ses entrées numériques et analogiques, un pupitre de order facile à lire et empilable et une télécommande sans fil.'),
('ENC-RAZ',5,'Nommo',199,'Razer/Nommo.jpg',2,3,1,'Avec la Razer Nommo, immergez-vous complètement dans votre expérience vidéoludique grâce à de haut-parleurs conçus pour obtenir une extrême clarté et une gamme complète de sons. Ce kit 2.0 vous emmène dans une nouvelle dimension qui efface la limite entre la fiction et la réalité.'),
('ENC-RAZ',5,'Nommo Chroma',179,'Razer/Nommo_Chroma.jpg',6,3,1,'Avec la Razer Nommo Chroma, immergez-vous complètement dans votre expérience vidéoludique grâce à de haut-parleurs conçus pour obtenir une extrême clarté et une gamme complète de sons. Ce kit 2.0 vous emmène dans une nouvelle dimension qui efface la limite entre la fiction et la réalité.'),
('ENC-RAZ',5,'Nommo Pro',599,'Razer/Nommo_Pro.jpg',3,3,1,'Vivez une expérience unique grâce à la technologie du son Virtuel Surround des enceintes Razer Nommo Pro. Ce kit 2.1 transforme votre façon dont vous écoutez la musique, regardez des films ou jouez à vos jeux préférés.'),
('ENC-RAZ',5,'Leviathan',249,'Razer/Leviathan.jpg',7,3,1,'La barre de son surround 5.1 Razer Leviathan se place facilement sous un écran de bureau ou une console de salon. Cette barre de son polyvalente est dotée de la technologie de pointe Dolby, de haut-parleurs de qualité supérieure, et d''un caisson de graves dédié.'),
('TAP-LOG',1,'G240',19,'logitech/G240.jpg',4,5,1,'Le tapis de souris Logitech G240 Cloth Gaming Mouse Pad présente une surface en tissu à faible friction, parfaitement adaptée au jeu haute résolution, améliorant le contrôle de la souris et permettant un placement précis du curseur.'),
('TAP-LOG',1,'G440',38,'logitech/G440.jpg',23,5,1,'Le tapis de souris Logitech G440 présente une surface en polymère rigide à faible friction, parfaitement adaptée au jeu haute résolution, améliorant le contrôle de la souris et permettant un placement précis du curseur.'),
('TAP-LOG',1,'G440 Hard Gaming',32,'logitech/G440_Hard_Gaming.jpg',9,5,1,'Le tapis de souris Logitech G440 présente une surface en polymère rigide à faible friction, parfaitement adaptée au jeu haute résolution, améliorant le contrôle de la souris et permettant un placement précis du curseur.'),
('TAP-LOG',1,'G640',39,'logitech/G640.jpg',7,5,1,'Le tapis de souris Logitech G640 Cloth Gaming Mouse Pad présente une surface en tissu à faible friction, parfaitement adaptée au jeu haute résolution, améliorant le contrôle de la souris et permettant un placement précis du curseur.'),
('TAP-LOG',1,'G840 XL',57,'logitech/G840_XL.jpg',12,5,1,'Idéal pour accueillir tous vos équipements, le tapis de souris Logitech G840 XL Gaming Mouse Pad recouvrira l''intégralité de votre bureau. La texture homogène de la surface améliore les performances des capteurs, tout particulièrement avec les souris de jeu Logitech G.'),
('TAP-LOG',1,'Powerplay',139,'logitech/Powerplay.jpg',16,5,1,'Avec le Logitech Powerplay, bienvenue dans le futur du gaming sans fil, placé sous le signe d''une technique avancée et d''une conception inégalée. Le module Powercore transforme le champ énergétique du système Powerplay en courant de charge et se lie magnétiquement aux souris pour la recharger.'),
('TAP-MIL',3,'Surface S',9,'Millenium/Surface_S.jpg',4,5,1,'Tapis de souris de qualité, le Millenium Surface S est parfaitement adapté à tous les types de surface et dispose d''une base antidérapante afin de vous permettre d''effectuer de grand mouvement sans que le tapis ne bouge.'),
('TAP-MIL',3,'Surface M',12,'Millenium/Surface_M.jpg',5,5,1,'Tapis de souris de qualité, le Millenium Surface M est parfaitement adapté à tous les types de surface et dispose d''une base antidérapante afin de vous permettre d''effectuer de grand mouvement sans que le tapis ne bouge.'),
('TAP-MIL',3,'Surface L',19,'Millenium/Surface_L.jpg',6,5,1,'Tapis de souris de qualité, le Millenium Surface L est parfaitement adapté à tous les types de surface et dispose d''une base antidérapante afin de vous permettre d''effectuer de grand mouvement sans que le tapis ne bouge.'),
('TAP-MIL',3,'Surface XL',29,'Millenium/Surface_XL.jpg',16,5,1,'Tapis de souris de qualité, le Millenium Surface XL est parfaitement adapté à tous les types de surface et dispose d''une base antidérapante afin de vous permettre d''effectuer de grand mouvement sans que le tapis ne bouge.'),
('TAP-MIL',3,'Surface RGB',42,'Millenium/Surface_RGB.jpg',14,5,1,'Tapis de souris de qualité, le Millenium Surface RGB vous offre la possibilité de donner un look unique à votre setup. Disposant d''une bande RGB personnalisable, il sera un allié de choix pour vos combats.'),
('TAP-STE',4,'QcK Prism Cloth 3XL',119,'SteelSeries/QcK_Prism_Cloth_3XL.jpg',17,5,1,'Ne manquez plus jamais d''espace pour vos périphériques grâce au SteelSeries QcK 3XL. Conçu pour les gamers, il intègre des LED RGB sur tous les côtés du tapis avec 16,8,1 millions de couleurs  que vous pourrez régler.'),
('TAP-STE',4,'QcK Prism Cloth (Extra Large)',69,'SteelSeries/QcK_Prism_Cloth_Extra_Large.jpg',12,5,1,'Le SteelSeries QcK Prism Cloth est un tapis de souris qui va vous offrir un contrôle absolu tout en vous immergeant dans votre jeu. Conçu pour les gamers, il intègre des LED RGB sur tous les côtés du tapis avec 16,8,1 millions de couleurs  que vous pourrez régler.'),
('TAP-STE',4,'QcK 3XL',59,'SteelSeries/QcK_3XL.jpg',13,5,1,'Ne manquez plus jamais d''espace pour vos périphériques grâce au SteelSeries QcK 3XL. Ce tapis haute performance de très grande taille vous offre une couverture totale de votre bureau afin de vous permettre d''installer confortablement votre souris et votre clavier.'),
('TAP-STE',4,'QcK Heavy XXL',44,'SteelSeries/QcK_Heavy_XXL.jpg',6,5,1,'Le SteelSeries QcK Heavy XXL est un tapis haute performance de très grande taille. Il est consitué des mêmes matériaux que le célèbre QcK, avec un format bien plus imposant, pour le clavier et la souris. Il est compatible avec tous les types de souris.'),
('TAP-STE',4,'QcK Prism Cloth (Medium)',49,'SteelSeries/QcK_Prism_Cloth_Medium.jpg',11,5,1,'Le SteelSeries QcK Prism Cloth est un tapis de souris qui va vous offrir un contrôle absolu tout en vous immergeant dans votre jeu. Conçu pour les gamers, il intègre des LED RGB sur tous les côtés du tapis avec 16,8,1 millions de couleurs  que vous pourrez régler.'),
('TAP-COR',2,'MM800C RGB Polaris',79,'Corsair/MM800C_RGB_Polaris.jpg',12,5,1,'Affichez clairement vos intentions avec le tapis de souris Corsair MM800C Polaris. Un modèle avec rétro-éclairage multicolore personnalisable et surface textile tissé pour une grande précision, même à pleine vitesse. Ce tapis dispose également d''une base antidérapante et de son propre port USB.'),
('TAP-COR',2,'MM500 (Extended 3XL)',54,'Corsair/MM500_Extended_3XL.jpg',11,5,1,'Jouez dans des conditions extrêmement confortables grâce au tapis de souris Corsair Gamming MM500. Optimisé pour la performance, ce tapis de souris de 1220 x 610 mm offre beaucoup de place pour votre souris, votre clavier, votre écran et bien plus encore.'),
('TAP-RAZ',5,'Firefly v2 Chroma',69,'Razer/Firefly_v2_Chroma.jpg',6,5,1,'Version améliorée du Firefly, le Firefly v2 Chroma est conçu principalement pour le gaming. Ultrafin, ce tapis de souris possède également un rétroéclairage RGB Chroma afin d''illuminer vos parties.'),
('TAP-RAZ',5,'Goliathus Chroma Extended (Taille XL)',79,'Razer/Goliathus_Chroma_Extended_Taille_XL.jpg',1,5,1,'Prêt à illuminer chacune de vos victoires, le tapis de souris Razer Goliathus Chroma Extended vous offre rapidité et précision, le tout dans un magnifique spectre de couleurs. La surface précise et uniforme vous garantit que chaque mouvement de la souris se traduit en un mouvement du curseur.'),
('TAP-RAZ',5,'Goliathus Chroma Extended Quartz Edition (Taille XL)',69,'Razer/Goliathus_Chroma_Extended_Quartz_Edition_Taille_XL.jpg',4,5,1,'Prêt à illuminer chacune de vos victoires, le tapis de souris Razer Goliathus Chroma Extended vous offre rapidité et précision, le tout dans un magnifique spectre de couleurs. La surface précise et uniforme vous garantit que chaque mouvement de la souris se traduit en un mouvement du curseur.'),
('TAP-DUC',6,'Flipper Extra R',29,'Ducky_Channel/Flipper_Extra_R.jpg',3,5,1,'Le Ducky Channel Flipper Extra R est conçu pour satisfaire les hautes exigences des véritables gamers. Grâce à sa surface finement texturée, ce tapis de souris offre confort et précision.');


INSERT INTO characteristics (idCharacteristics, idTypeProduct, title) VALUES
(1,1,'utilisation'),
(2,1,'couleur'),

(10,6,'sans fil'),
(11,6,'type de touches'),
(12,6,'type de switches'),
(13,6,'clavier rétroéclairé'),
(14,6,'rétroéclairage rgb'),
(15,6,'interface avec l''ordinateur'),
(16,6,'norme du clavier'),

(20,2,'type de souris'),
(21,2,'interface avec l''ordinateur'),
(22,2,'nombre de boutons'),
(23,2,'led rgb'),
(24,2,'couleur'),
(25,2,'ambidextre'),
(26,2,'résolution optique dpi'),
(27,2,'sans fil');

-- INSERT INTO product_characteristics (idProduct, idCharacteristics, valeur) VALUES
-- (1,1,'gamer'),
-- (1,2,'noir'),
-- (1,10,'non'),
-- (1,11,'mécaniques'),
-- (1,12,'brow'),
-- (1,13,'oui'),
-- (1,14,'oui'),
-- (1,15,'usb'),
-- (1,16,'azerty'),
--
-- (2,1,'gamer'),
-- (2,2,'noir'),
-- (2,10,'non'),
-- (2,11,'mécaniques'),
-- (2,12,'red'),
-- (2,13,'oui'),
-- (2,14,'oui'),
-- (2,15,'usb'),
-- (2,16,'azerty'),
--
-- (3,1,'gamer'),
-- (3,2,'noir'),
-- (3,10,'oui'),
-- (3,11,'mécaniques'),
-- (3,12,'brown'),
-- (3,13,'oui'),
-- (3,14,'oui'),
-- (3,15,'Bluetooth'),
-- (3,16,'azerty'),
--
-- (4,1,'gamer'),
-- (4,2,'noir'),
-- (4,10,'non'),
-- (4,11,'mécaniques'),
-- (4,12,'bleu'),
-- (4,13,'oui'),
-- (4,14,'oui'),
-- (4,15,'usb'),
-- (4,16,'azerty'),
--
-- (35,1,'gamer'),
-- (35,2,'noir'),
-- (35,20,'laser'),
-- (35,21,'usb'),
-- (35,22,'2'),
-- (35,23,'oui'),
-- (35,24,'gris'),
-- (35,25,'non'),
-- (35,26,'10000'),
-- (35,27,'non');
--
-- (36,1,'gamer'),
-- (36,2,'noir'),
-- (36,20,'laser'),
-- (36,21,'usb'),
-- (36,22,'2'),
-- (36,23,'oui'),
-- (36,24,'gris'),
-- (36,25,'non'),
-- (36,26,'10000'),
-- (36,27,'non');
--
-- (37,1,'gamer'),
-- (37,2,'noir'),
-- (37,20,'laser'),
-- (37,21,'usb'),
-- (37,22,'2'),
-- (37,23,'oui'),
-- (37,24,'gris'),
-- (37,25,'non'),
-- (37,26,'10000'),
-- (37,27,'non');
--
-- (38,1,'gamer'),
-- (38,2,'noir'),
-- (38,20,'laser'),
-- (38,21,'usb'),
-- (38,22,'2'),
-- (38,23,'oui'),
-- (38,24,'gris'),
-- (38,25,'non'),
-- (38,26,'10000'),
-- (38,27,'non');


INSERT INTO basket (idUser, createdBasket) VALUES
(1,'2020/12/17'),
(2,'2020/12/16'),
(3,'2020/12/15');

-- INSERT INTO product_basket (idProduct, idBasket, quantity) VALUES
-- (1,1,2),
-- (1,2,1),
-- (2,2,1),
-- (3,2,1),
-- (6,3,1),
-- (7,3,1);


INSERT INTO allOrder (idUser, idBasket, date, totalPrice) VALUES
(1,1,'2020/12/17',400),
(2,2,'2020/12/17',500),
(3,3,'2020/12/17',600);

INSERT INTO score_user_product (idUser, idProduct) VALUES
(1,12),
(1,22),
(1,34),
(1,45),
(1,57),
(2,21),
(3,12);
