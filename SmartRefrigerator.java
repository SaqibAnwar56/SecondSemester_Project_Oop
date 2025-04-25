class  ManualGuide{
     private String instructions;
    ManualGuide(String instructions){
        this.instructions=instructions;
    }
    public void displayGuide(){
        System.out.println("User Manual:"+instructions);
    }
        }
class Motor {
 public void StartTheMotor() {
        System.out.println("Motor Started");
    }

    void StopTheMotor() {
     System.out.println("Motor Stopped");
    }


}
    class FreezerUnit{
    void activateFreezer(){
            System.out.println("Freezer is cooling");
        }
        void deactivateFreezer(){
        System.out.println("Freezer is turned off");
        }
    }
    class Refrigerator extends Thread {
        private  String brand;
        private String model;

        Motor motor;
        FreezerUnit freezerUnit;
        ManualGuide manualGuide;

        Refrigerator(String brand, String model, ManualGuide manualGuide) {
            this.brand = brand;
            this.model = model;
            this.manualGuide = manualGuide;
            this.motor = new Motor();
            this.freezerUnit = new FreezerUnit();
        }

        void StartSystem() {
            System.out.println("Starting," + brand + " " + model + "...");
            motor.StartTheMotor();
            freezerUnit.activateFreezer();
            start();
        }

        void ShutdownSystem() {
            motor.StopTheMotor();
            freezerUnit.deactivateFreezer();
            interrupt();
            System.out.println(brand + " " + model + " is shut down.");
        }

        void readManual() {
            manualGuide.displayGuide();
        }


        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("Auto-check: Temperature is stable.");
                    Thread.sleep(4000); // Simulate temperature monitoring
                }
            } catch (InterruptedException e) {
                System.out.println("Temperature regulation interrupted.");
            }
        }


    }


public class SmartRefrigerator {
    public static void main(String[] args) {
ManualGuide guide=new ManualGuide("close the door for best cooling:");
Refrigerator myFridge=new Refrigerator("HAIER","HRF-538IARA",guide);

myFridge.StartSystem();
try {
    Thread.sleep(1000);

} catch (InterruptedException e) {
    e.printStackTrace();
}
myFridge.readManual();
myFridge.ShutdownSystem();

    }
}
