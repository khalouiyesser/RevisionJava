public class Etudiant3em extends Etudiant{

    private String branche;



    public Etudiant3em(int id, String nom, String prenom, float moyenne,String branche) {
        super(id, nom, prenom, moyenne);
        this.branche= branche;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    @Override
    public void ajouterabscence(){
        this.moyenne -= 0.5;
    }
}
