public class EtudiantExisteException extends Throwable {
    public class etudiantExisteException extends Exception {
        public etudiantExisteException() {
            super("L'étudiant existe déjà.");
        }
    }
}
