
import java.util.Random;
public class LotteryPrinter
{
public static void main(String[]args)

{
Random generator= new Random();
System.out.println("zhgjidh 6 nga numrat e meposhtem dhe provoni:");
System.out.print("numrat e llotarise:");
for(int i=0;i<6;++i)
System.out.print(" "+(generator.nextInt(49)+1));
}

}	
