import java.math.BigDecimal;
import java.util.Random;

public class PlayerThread extends Thread {

    private double burst;
    private String name;
    private Route route;

    public PlayerThread(String name, Route route) {
        this.route = route;
        this.name = name;
        float randomBurst = new Random().nextFloat();
        this.burst = roundWith2Places(randomBurst);
    }

    @Override
    public void run() {
        System.out.println("-> O jogador " + name + " começou com o incentivo igual a " + String.format( "%.2f", burst));
        double step = 0;
        boolean half = false;
        int finalStep = route.getFinalStep();
        int boundStep = route.getBoundStep();
        while (step <= finalStep) {
            Random random = new Random();
            int randomStep = random.nextInt(boundStep);
            step = step + (randomStep * burst);
            if ((step >= finalStep / 2) && !half) {
                half = true;
                System.out.println("+ O jogador " + name + " chegou a metade do percurso!");
            }
            sleep();
        }
        System.err.println("* O jogador " + name + " chegou ao fim!");
    }

    private void sleep() {
        try {
            Thread.sleep( 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private float roundWith2Places(double number) {
        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}

