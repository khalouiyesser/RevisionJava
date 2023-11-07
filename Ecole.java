import java.lang.reflect.Array;
import java.util.Arrays;
import exceptions.EtudiantExisteException;


public class Ecole {
    private String nom;
    private Etudiant[] etudiants ;
    private int nbEtudiant = 0;
    final int  nbMax=500;

    public Ecole(String nom, int nbMax){
        this.nom=nom;
        this.etudiants=new Etudiant[nbMax];

    }
    public void ajouterEtudiant(Etudiant e) {
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
//    public boolean ajouterEtudiantCondition(Etudiant e) {
//        if (rechercherEtudiant(e) == -1) {
//            if (nbEtudiant < nbMax) {
//                etudiants[nbEtudiant] = e;
//                nbEtudiant++;
//                return true; // L'étudiant a été ajouté avec succès.
//            } else {
//                System.out.println("L'école est pleine, impossible d'ajouter un nouvel étudiant.");
//            }
//        } else {
//            System.out.println("Cet étudiant est déjà inscrit à l'école.");
//        }
//        return false; // L'étudiant n'a pas été ajouté.
//    }
    float Moyen =0;
    public float getMoyenneDes3A(){
        for (int i=0; i <=nbEtudiant;i++){
         Moyen =+ etudiants[i].moyenne;
        }
        return Moyen/nbEtudiant;
    }
//    float MoyenSalaire = 0;
//    public float getMoyenneSalaire(){
//        for (int i=0; i <=nbEtudiant;i++){
//            MoyenSalaire =+ etudiants[i].;
//        }
//        return Moyen/nbEtudiant;
//    }
//

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
//    public void changerEcole(Etudiant etd, Ecole ecole){
//        try{
//            ecole.ajouterEtudiant(etd);
//        }catch (EtudiantExisteException ex){
//            System.out.println(ex);
//
//        }
//    }
//    public void changerEcole(Etudiant etd, Ecole e) throws EtudiantExisteException{
//        try {
//            e.ajouterEtudiant(etd);
//        } catch (EtudiantExisteException ex) {
//            ex.printStackTrace();
//        }
//        this.supprimerEtudiant(etd);
//    }
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


    public class EtudiantExisteException extends Exception {
        public EtudiantExisteException() {
            super("L'étudiant existe déjà.");
        }
    }



}
