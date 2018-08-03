package study.studyjava;

public class Inheritance {
    public static void main(String args) {

    }
    public static class Bicycle {

        // the Bicycle class has three fields
        public int cadence;
        public int gear;
        public int speed;

        // the Bicycle class has one constructor
        public Bicycle(int startCadence, int startSpeed, int startGear) {
            gear = startGear;
            cadence = startCadence;
            speed = startSpeed;
        }

        // the Bicycle class has four methods
        public void setCadence(int newValue) {
            cadence = newValue;
        }

        public void setGear(int newValue) {
            gear = newValue;
        }
        public int getGear() {
            return gear;
        }

        public void applyBrake(int decrement) {
            speed -= decrement;
        }

        public void speedUp(int increment) {
            speed += increment;
        }

    }// todo 作为inner class要能够被其他引用，需要设置属性为static为啥？
    public static class MountainBike extends Bicycle {

        // the MountainBike subclass adds one field
        public int seatHeight;

        // the MountainBike subclass has one constructor
        public MountainBike(int startHeight,
                            int startCadence,
                            int startSpeed,
                            int startGear) {
            super(startCadence, startSpeed, startGear);  // 利用了superclass的constructor，这样subclass的constructor就简短了
            seatHeight = startHeight;
        }

        // the MountainBike subclass adds one method
        public void setHeight(int newValue) {
            seatHeight = newValue;
        }
    }// todo 作为inner class要能够被其他引用，需要设置属性为static为啥？
}
