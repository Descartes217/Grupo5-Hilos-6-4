
public class Cronometro extends Thread {

    void reloj() {

    }

    public static void main(String[] args) {

        int seg = 0;
        int min = 0;
        int ho = 0;

        try {

            while(true){
                System.out.println(Thread.currentThread().getName()+" "+ ho+":"+min+":"+seg);
                
                seg++;
                if(seg>59){
                    seg=0;
                    min++;
                }
               
                if(min>59){
                    min=0;
                    ho++;
                }

                sleep(1000);
              
            }

        } catch (Exception e) {

        }
    }
}