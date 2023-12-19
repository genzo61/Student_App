public class StudentApp {

    interface articlescorebehaviour{
        float articlescore();
    }
    interface conferancescorebehaviour{
        float conferancescore();
    }
    interface projectscorebehaviour{
        float projectscore();
    }
    abstract class Student{
        private int id;
        private float mid;
        private float fin;

        public Student(int id , float mid , float fin){
            this.id = id;
            this.mid = mid;
            this.fin = fin;
        }
        abstract float computetotalscore();
        float computebasescore(){
            return (float) (mid * 0.4 + fin * 0.6);
        }
    }
    class Masterstudent extends Student implements conferancescorebehaviour{
        protected int numberofcount;
        public Masterstudent(int id,float mid,float fin,int numberofcount){
            super(id, mid, fin);
            this.numberofcount = numberofcount;
        }
        float computetotalscore(){
            return computebasescore() + conferancescore();
        }
        public float conferancescore(){
            return numberofcount * 5;
        }
    }
    class Bachelourstudent extends Student implements projectscorebehaviour{
        public Bachelourstudent(int id, float mid, float fin){
            super(id, mid, fin);
        }
        float computetotalscore(){
            return computebasescore() + projectscore();
        }
        public float projectscore(){
            return 20;
        }
    }
    class Phdstudent extends Masterstudent implements articlescorebehaviour{
        int numberofarticles;
        public Phdstudent(int id,float mid,float fin,int count,int numberofarticles){
            super(id,mid,fin,count);
            this.numberofarticles=numberofarticles;
        }

        @Override
        public float computetotalscore() {
            return computetotalscore() + articlescore();
        }
        public float articlescore(){
            return numberofarticles * 8;
        }
    }

    public static void main(String[] args) {
        // we can call methods
    }
}
