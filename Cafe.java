/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * <p> Removes variables size as ounces of coffee, number of sugar packets and amount of cream from inventory and restocks if empty.
     * @param size the same of the coffee that is being sold/removed from inventory
     * @param nsugarPackets the number of sugar packers that are being sold/rmoved from the inventory
     * @param ncreams the number of creams that are being sold/removed from the inventory
     */
    public void sellCoffee(int size, int nsugarPackets, int ncreams){
        if(nCups>1){
        if (size <= nCoffeeOunces){
            if (nsugarPackets <= nSugarPackets){
                if (ncreams <= nCreams){
                    nCoffeeOunces = nCoffeeOunces - size;
                    nSugarPackets = nSugarPackets - nsugarPackets;
                    nCreams =  nCreams - ncreams;
                    nCups = nCups - 1;
                }else{
                    restock(nCoffeeOunces, nSugarPackets, 5, nCups);
                }
            }else{
                restock(nCoffeeOunces, 5, nCreams, nCups);
            }
        }else{
            restock(10, nSugarPackets, nCreams, nCups);
        }
    }else{
        restock(nCoffeeOunces, nSugarPackets, nCreams, 5);
    }
    }
    /**
     * <p> For each variable, sets it to the inputted value, effectively 'resetting' the values
     * @param ncoffeeOunces this is the number of coffee ounces that we are setting the new inventory balance to
     * @param nsugarPackets this is the number of sugar packets that we are setting the new inventory balance to
     * @param ncreams this is the number of creams that we are setting the new inventory balance to
     * @param ncups this is the number of cups that we are setting the new inventory balance to
     */
    private void restock(int ncoffeeOunces, int nsugarPackets, int ncreams, int ncups){
        if (ncoffeeOunces>0){
            nCoffeeOunces = ncoffeeOunces;
            System.out.println("we have added "+ncoffeeOunces+" of coffee. Please retry your purchase!");
        }else{
            throw new RuntimeException("Please enter a postive whole number");
        }
        if(nsugarPackets>0){
            nSugarPackets = nsugarPackets;
            System.out.println("we have added "+nsugarPackets+" packets of sugar. Please retry your purchase!");
        }else{
            throw new RuntimeException("Please enter a postive whole number");
        }
        if(ncreams>0){
            nCreams = ncreams;
            System.out.println("we have added "+ncreams+" creams. Please retry your purchase!");
        }else{
            throw new RuntimeException("Please enter a postive whole number");
        }
        if(ncups>0){
            nCups =ncups;
            System.out.println("we have added "+ncups+" cups. Please retry your purchase!");
        }else{
            throw new RuntimeException("Please enter a postive whole number");
        }
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "70 Elm Street", 1, 10, 10, 10, 1);
        myCafe.sellCoffee(1, 1, 1);
        myCafe.sellCoffee(1, 1, 1);
    }
    
}
