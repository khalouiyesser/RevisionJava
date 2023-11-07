public abstract class Etudiant {
    protected int id;
    protected String nom,prenom;
//    protected  boolean abscence;

    protected float moyenne ;

    public Etudiant (int id,String nom ,String prenom,float moyenne,boolean abscence){
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
//        this.abscence = abscence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public static Etudiant getE() {
        return e;
    }

    public static void setE(Etudiant e) {
        Etudiant.e = e;
    }

//    static Etudiant e = new Etudiant(1,"khaloui","yesser", 17.25F);
    public String toString(){
        return "id:"+ " "+id+" "+"nom:"+" "+nom+"prenom"+prenom+"moyenne"+moyenne;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Etudiant e){
            return (this.id == e.id && this.nom == e.nom);
        }
        return false ;
    }
    public abstract void ajouterabscence();


    public static void main(String[] args) {

//        System.out.println(e);
    }
}
