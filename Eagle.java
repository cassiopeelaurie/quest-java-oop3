public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!flying && altitude == 0) {
            flying = true;
            System.out.println(this.getName() + " takes off in the sky.");
        } else {
            System.out.println(this.getName() + " is already flying.");
        }
    }

    @Override
    public void glide() {
        if (flying && altitude > 0) {
            System.out.println(this.getName() + " glides into the air.");
        } else {
            System.out.println(this.getName() + " can't glide while not flying.");
        }
    }

    @Override
    public void land() {
        if (flying && altitude < 10) {
            flying = false;
            System.out.println(this.getName() + " lands on the ground.");
        } else if (flying && altitude >= 10) {
            System.out.println(this.getName() + " is too high, it can't land.");
        } else {
            System.out.println(this.getName() + " is already on the ground.");
        }
    }

    @Override
    public int ascend(int meters) {
        altitude += meters;
        if (flying) {
            System.out.printf("%s flies upward, altitude: %d%n", this.getName(), altitude);
        }
        return altitude;
    }

    @Override
    public int descend(int meters) {
        if (flying) {
            altitude -= meters;
            if (altitude < 0) {
                altitude = 0;
            }
            System.out.printf("%s flies downward, altitude: %d%n", this.getName(), altitude);
        }
        return altitude;
    }
}
