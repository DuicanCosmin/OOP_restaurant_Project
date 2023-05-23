Scop:

Aplicatia are ca scop simpla simulare a unui restaurant.

La pornirea aplicatie, aceasta va verifica daca exista o baza de date Sqlite si un fisier CSV care serveste ca
loc pentru loguri.
Daca nu exista va incerca sa le creeze. Daca nu reuseste va afisa un mesaj si va iesi din aplicatie.

Modelele care au legatura cu mancarea au la baza o clasa abstracta din care mostenesc celelalte 2 modele, adaugand
functionalitati noi.

Pentru accesarea bazei am implementat un model de repository. Fiecare model are un repository care implementeza o
interfata. La pornirea aplicatiei este chemata o metoda de initializare care verifica baza de date si fisierul de loguri.


Pentru vizualizare am creat o clasa de baza, din care implementez alte clase pentru vizualizare cu metode individuale.


