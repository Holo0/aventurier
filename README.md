## Projet de Simulation de Mouvement sur une Carte

# Description
Ce projet vise à modéliser les mouvements d'un aventurier sur une carte. Cette carte est représentée par des caractères dans un fichier texte UTF-8. Les '#' sont des arbres qui bloquent l'aventurier dans ses mouvements tant que les ' ' sont des espaces libres où l'aventurier peut aller. Enfin, les mouvements de l'aventurier sont lu dans un autre fichier et indique la direction dans laquelle l'aventurier doit aller.

# Structure du Projet
Le projet est structuré de manière modulaire avec les classes suivantes :
- Carte : Gère la structure de la carte, charge la carte depuis un fichier UTF-8 et vérifie si un mouvement est valide.
- Personnage : Suit la position du personnage et permet de déplacer celui-ci selon les directions données.
- Jeu : Gère l'état global du jeu, traite les directions d'entrée et fait le lien entre le personnage et la carte.
- EnumDirection : Enumération qui encapsule la logique de direction (N, S, E, O).

# Installation sur Windows
1- Installer Java 17

2- Clonez le dépôt :
``` bash
git clone https://github.com/Holo0/aventurier.git
cd aventurier
```

3- Compilez les fichiers sources :
``` bash
javac -d bin .\src\main\java\fr\cirilgroup\aventurier\Main.java .\src\main\java\fr\cirilgroup\aventurier\entities\*.java
```

4- Exécutez le programme :
``` bash
java -cp target\classes fr.cirilgroup.aventurier.Main
```

# Utilisation
Pour exécuter le programme, placez votre fichier de carte et de déplacements dans le répertoire resources. Modifiez le fichier Main.java si nécessaire pour pointer vers vos fichiers :
``` java
public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game("carte v2.txt", "deuxieme_test.txt"); // ICI
            game.displayPosition();
            game.processMoves(game.getMoves());
        } catch (IOException e) {
            System.err.println("Error loading map file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
