public class DungeonTester{
  public static void main(String[]args){
    Dungeon d = new Dungeon(5,5);
    System.out.println("curr room"+d.getCurrentRoom().getName());
    System.out.println("avail room: \n"+d.getCurrentRoom().getAvailableDoors());
    d.changeRoom("LEFT");
    System.out.println("curr room"+d.getCurrentRoom().getName());
    System.out.println("avail room: \n"+d.getCurrentRoom().getAvailableDoors());
    d.changeRoom("LEFT");
    System.out.println("curr room"+d.getCurrentRoom().getName());
    System.out.println("avail room: \n"+d.getCurrentRoom().getAvailableDoors());
  }
}