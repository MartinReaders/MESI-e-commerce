INSERT INTO utilisateur (username, password, grade) VALUES
('Pierre','POCHERON',1),
('Dylan','ANTONIOTTI',1),
('Martin','KHAPHERIAN',1),
('Manahel','BOUCHKARA',1),
('root','root',2),
('user','user',2);


INSERT INTO produit (code, marque, modele, prix, image, quantite, type) VALUES
(00001,'Logitech','G513',160,'/img/logitech/G513',5,'clavier'),
(00002,'Logitech','G PRO',160,'/img/logitech/G_PRO',3,'clavier'),
(00003,'Logitech','G502',60,'/img/logitech/G502',6,'souris'),
(00004,'Logitech','G560',255,'/img/logitech/G560',10,'enceinte'),
(00005,'Logitech','G404',50,'/img/logitech/G404',4,'tapis de souris'),
(00006,'Corsair','K68',84,'/img/logitech/K68',0,'clavier'),
(00007,'Razer','Blackwidow Elite ',130,'/img/logitech/Blackwidow_Elite ',2,'clavier');


INSERT INTO panier (idUtilisateur, createdPanier) VALUES
(1,'2020/12/17'),
(2,'2020/12/16'),
(3,'2020/12/15'),
(4,'2020/12/14');

INSERT INTO produit_panier (idProduit, idPanier, quantite) VALUES
(1,1,2),
(1,2,1),
(2,2,1),
(3,2,1),
(6,3,1),
(7,3,1),
(1,4,1),
(4,4,1),
(5,4,1);

INSERT INTO commande (idUtilisateur, idPanier, dateCommande, prixTotal) VALUES
(1,1,'2020/12/17',320),
(2,2,'2020/12/17',500),
(3,3,'2020/12/17',500),
(4,4,'2020/12/17',500);
