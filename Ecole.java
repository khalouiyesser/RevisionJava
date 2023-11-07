import java.util.Arrays;


public class Ecole {
    private String nom;
    private Etudiant[] etudiants ;
    private int nbEtudiant = 0;
    final int  nbMax=500;

    public Ecole(String nom, int nbMax){
        this.nom=nom;
        this.etudiants=new Etudiant[nbMax];

    }
    public void ajouterEtudiant(Etudiant e) throws EtudiantExisteException {
        if (nbEtudiant < nbMax && rechercherEtudiant(e) == -1) {
            etudiants[nbEtudiant] = e;
            nbEtudiant++;
        } else {
            System.out.println("L'école est pleine, impossible d'ajouter un nouvel étudiant.");
        }
    }
    public int rechercherEtudiant(Etudiant e) {
        for (int i = 0; i < nbEtudiant; i++) {
            if (etudiants[i] != null && etudiants[i].equals(e)) {
                return i; // Étudiant trouvé, renvoyer son indice
            }
        }
        return -1; // Étudiant non trouvé, renvoyer -1
    }

    float Moyen =0;
    public float getMoyenneDes3A(){
        for (int i=0; i <=nbEtudiant;i++){
         Moyen =+ etudiants[i].moyenne;
        }
        return Moyen/nbEtudiant;
    }


    public float calculerMoyenneSalaires(){
        float sum = 0;
        int nbrAlt = 0;
        for (Etudiant e: etudiants) {
            if(e instanceof EtudiantAlternance ealt){
                sum += ealt.getSalaire();
                nbrAlt++;
            }
        }
        return sum/nbrAlt;
    }

public void supprimerEtudiant(Etudiant e) {
    int index = rechercherEtudiant(e);
    etudiants[index] = null;

    for (int i = index; i < nbEtudiant; i++) {
        etudiants[i] = etudiants[i+1];
    }
    etudiants[nbEtudiant] = null;
    nbEtudiant--;
}



        public void changerEcole(Etudiant etd, Ecole e){
            try {
                e.ajouterEtudiant(etd);
            } catch (EtudiantExisteException ex) {
                ex.printStackTrace();
            }
            this.supprimerEtudiant(etd);
        }



    @Override
    public String toString(){
        return "Ecole : "+ nom+ "Etudiants:" + Arrays.toString(etudiants);
    }






}
