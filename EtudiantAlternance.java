public class EtudiantAlternance extends Etudiant{

    private int salaire;
    public EtudiantAlternance(int id, String nom, String prenom, float moyenne, boolean abscence,int salaire) {
        super(id, nom, prenom, moyenne, abscence);
        this.salaire=salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public void ajouterabscence() {
        salaire-= 50;

    }
    @Override
    public String toString(){
        return "id:"+id +"nom"+ nom+"prenom"+ prenom+ "moyenne :"+moyenne;

    }
}
