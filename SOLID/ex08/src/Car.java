public class Car implements EngineVehicle, Rechargeable {
    private boolean engineOn = false;
    private int batteryLevel = 0;
    
    @Override
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("Engine started");
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("Engine stopped");
        } else {
            System.out.println("Engine is already off");
        }
    }
    
    @Override
    public void recharge(int kWh) {
        batteryLevel += kWh;
        System.out.println("Charged: " + kWh + "kWh. Battery level: " + batteryLevel + "kWh");
    }
}
