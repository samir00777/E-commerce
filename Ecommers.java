import java.util.Scanner;
class ECommerce
{
    public static void main(String[] args) 
    {
        ECommerce5 pm5=new ECommerce5();
        pm5.main1();

        String card="";
        int opr=0;
        Scanner input=new Scanner(System.in);
        System.out.print("Credit/Debit Card number: ");
        card=input.next();

        while(card.length()!=16)
        {
            System.out.print("Card number must be contains 16 digits only.\nTry again: ");
            card=input.next();

            for(int i=0;i<card.length();i++)
            {
                char c=card.charAt(i);
                if(c<'0' || c>'9')
                {
                    System.out.print("Card number must be contains 16 digits only.\nTry again: ");
                    card=input.next();
                    i=0;
                }
            }
        }

        for(int i=0;i<card.length();i++)
        {
            char c=card.charAt(i);
            String atIndex="";
            atIndex+=c;
            
            if(i%2==0)
            {
                int num=Integer.parseInt(atIndex);
                num+=num;
                if(num>9)
                {
                    num-=9;
                }
                opr+=num;
            }
            else
            {
                opr+=c-'0';
            }
        }

        if(opr%10==0)
        {
            System.out.print("Valid");
        }

        else 
        {
            System.out.println("Invalid");
        }

        //******************************************* */
    }
}
class ECommerce1 extends ECommerce
{
    String items="";
    int Price=0;

    static ECommerce1[] arr = new ECommerce1[4];
    
    static void main1()
    {
        Scanner scn=new Scanner(System.in);

        System.out.println("Enter your details to login.\n");
        System.out.print("Enter your name :-  ");
        String name =scn.nextLine();

        scn.nextLine();
        System.out.print("Enter your address :-  ");
        String address =scn.nextLine();

        System.out.println("\n");


        // varify m.no and otp

        String mno;

        while (true) 
        {
            System.out.print("Enter your 10-digit mobile number: ");
            mno = scn.nextLine();

            if (mno.length() == 10) 
            {
                boolean isValid = true;

                for (int i = 0; i < 10; i++) 
                {
                    if (mno.charAt(i) < '0' || mno.charAt(i) > '9') 
                    {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) 
                {
                    break;
                }
            }
        }


        int otp = (int) (Math.random() * 9000) + 1000;
        System.out.println("Your OTP is: " + otp);

        while (true) 
        {
            System.out.print("Enter OTP: ");
            String userOtp = scn.next();

            if (userOtp.length() == 4) 
            {
                boolean isValid = true;

                for (int i = 0; i < 4; i++) 
                {
                    if (userOtp.charAt(i) < '0' || userOtp.charAt(i) > '9') 
                    {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) 
                {
                    if (userOtp.equals(String.valueOf(otp))) 
                    {
                        System.out.println("OTP Verified Successfully!");
                        break;
                    }
                }
            }
        }

        //varify is over 

        for(int i=0; i<4; i++)
        {
            arr[i] = new ECommerce1();
        }
        ECommerce5 pm5=new  ECommerce5();
        
        while(true)
        {
            System.out.println(" =================================================================-> Welcome to my store <-===============================================================");
            System.out.println(" 1.Do you want to buy electronics items ? ");
            System.out.println(" 2.Do you want to buy home and living items ?  ");
            System.out.println(" 3.Do you want to buy vegetables and fruits  ? ");
            System.out.println(" 4.Do you want to buy snack & sweets ? ");
            System.out.println(" 5.Exit "+"\n");
            System.out.print("Enter the number of your choice :-");
            String n=scn.nextLine();

            switch (n) 
            {
                case "1" :
                {
                    pm5.electronicsitems();
                    break;
                }
                case "2" :
                {
                    pm5.homelivingitemes();
                    break ;
                }
                case "3" :
                {
                    pm5.vegetablesfruitsitems();
                    break;
                }
                case "4" :
                {
                    pm5.snekssweetsitems();
                    break;
                }
                case "5" :
                {
                    break;
                }
                default :
                {
                    System.out.println("/*/*/*  ==   Invalid choice! Please try again.  ==  /*/*/*/*/"+"\n");
                } 
            }

            double totalcost =0 ;

            for(int i=0; i<4; i++)
            {
                totalcost +=arr[i].Price;
            }

            if(n.equals("5"))
            {
                for(int i=0; i<4; i++)
                {
                    if(i==0)
                    {
                        if(arr[i].Price!=0)
                        {
                            System.out.println("\n");
                            System.out.println("electronics items are here :- ");
                            System.out.println("price of total electronics is :- "+arr[i].Price+"\t\n");
                            System.out.println("total electronics items is :- "+arr[i].items+" ");
                        }
                    }
                    if(i==1)
                    {
                        if(arr[i].Price!=0)
                        {
                            System.out.println("\n");
                            System.out.println("the home living itemes are here :- ");
                            System.out.println("price of total home living is :- "+arr[i].Price+"\t\n");
                            System.out.println("total home living items is :- "+arr[i].items+" ");
                        }
                    }   
                    if(i==2)
                    {
                        if(arr[i].Price!=0)
                        {
                            System.out.println("\n");
                            System.out.println("the vegetables and fruits items are here :- ");
                            System.out.println("price of total vegetables and fruits is :- "+arr[i].Price+"\t");
                            System.out.println("total home vegetables and fruits is :- "+arr[i].items+" ");
                        }
                    }   
                    if(i==3)
                    {
                        if(arr[i].Price!=0)
                        {
                            System.out.println("\n");
                            System.out.println("the sneks and sweets items are here :- ");
                            System.out.println("price of total sneks and sweets is :- "+arr[i].Price+"\t");
                            System.out.println("total sneks and sweets items is :- "+arr[i].items+" ");
                        }
                    }   
                }
                
                System.out.println("\n\n"+"your total and final  amount : "+totalcost+"\n"+"\n");
                System.out.println("This discount is provided to you through our platform.\n");

                if(totalcost>=5000 && totalcost<10000)
                {
                    System.out.println("Congratulations  you got a2% discount");
                    totalcost -= totalcost*0.02;
                    System.out.println("your final cost is a :- "+totalcost+"\n");
                }

                else if(totalcost>=10000 && totalcost<15000)
                {
                    System.out.println("Congratulations  you got a 3% discount");
                    totalcost -= totalcost*0.03;
                    System.out.println("your final cost is a :- "+totalcost+"\n");

                }

                else if(totalcost>=15000 && totalcost<20000)
                {
                    System.out.println("Congratulations  you got a 4% discount"+"\n");
                    totalcost -= totalcost*0.04;
                    System.out.println("your final cost is a :- "+totalcost);
                }

                else if(totalcost>=20000)
                {
                    System.out.println("Congratulations  you got a 6% discount");
                    totalcost -= totalcost*0.06;
                    System.out.println("your final cost is a :- "+totalcost+"\n");
                }

                games cc1=new games();

                for(int i=0; i<4; i++)
                {
                    String cc;
                    if(n.equals("5") && (arr[i].items).equals(""))
                    {}
                    else
                    {
                        System.out.println(" choose the game for more discount :- \n");
                        System.out.println(" 1.Rock-paper-Scissor");
                        System.out.println(" 2.rendom choose the number");
                        System.out.println(" 3.Tic-Tec-Toe");
                        System.out.println(" 4.exit");
                        cc=scn.nextLine();

                        switch (cc) 
                        {
                            case "1":
                            {
                                totalcost=cc1.RockPaperScissor(totalcost);
                                break;
                            }
                            case "2":
                            {
                                totalcost = cc1.choosethenumber(totalcost);
                                break;
                            }
                            case "3":
                            {
                                TicTecToe ss=new TicTecToe();
                                totalcost=ss.hellow(totalcost);
                                
                                break;
                            }
                            case "4":
                            {
                                break;
                            }
                            default:
                            {
                                System.out.println(" enter valid choice ");
                                i--;
                            }
                        }
                        if(cc.equals("1") && cc.equals("2") && cc.equals("3") && cc.equals("4"))
                        {
                            break;
                        }
                    }
                }          
            }

            System.out.println(" final cost is "+totalcost);

            if(n.equals("5"))
            {
                System.out.println("Thank you for using my system! \n");
                return;
            }
        }
        
    }
}
class ECommerce2 extends ECommerce1
{
    void electronicsitems()
    {
        Scanner scn=new Scanner(System.in);

        while(true)
        {
            
            System.out.println("Choose an item to add to your cart:");
            System.out.println("1. Bulb (Rs 100)");
            System.out.println("2. Sandwich Maker (Rs 1000)");
            System.out.println("3. Geyser (Rs 5000)");
            System.out.println("4. Refrigerator (Rs 10000)");
            System.out.println("5. Mobile Phone (Rs 15000)");
            System.out.println("6. Laptop (Rs 20000)");
            System.out.println("7. Washing Machine (Rs 25000)");
            System.out.println("8. Headphones (Rs 1000)");
            System.out.println("9. Trimmer (Rs 1100)");
            System.out.println("10. Hair Dryer (Rs 800)");
            System.out.println("11. Exit Electronics Menu \n");

            System.out.print("enter a sequence number :- ");
            String sk=scn.nextLine();

            switch (sk) 
            {
                case "1":
                {
                    System.out.println("added to cart the : bulb) that costs a 100rs.  "+"\n");
                    arr[0].items+="bulb, ";
                    arr[0].Price+=100;
                    break;
                }

                case "2":
                {
                    System.out.println("added to cart the  sandwitch maker  that costs a 1000rs. "+"\n");
                    arr[0].items+="sandwitch maker, "; 
                    arr[0].Price+=1000;
                    break;
                }

                case "3":
                {
                    System.out.println("added to cart the  geyser that costs a 5000rs. "+"\n");
                    arr[0].items+="geyser, "; 
                    arr[0].Price+=5000;
                    break;
                }

                case "4":
                {
                    System.out.println("added to cart the freeze that costs a 10000rs. "+"\n");
                    arr[0].items+="freeze, "; 
                    arr[0].Price+=10000;
                    break;
                }

                case "5":
                {
                    System.out.println("added to cart the  mobile that costs a 15000rs. "+"\n");
                    arr[0].items+="mobile, "; 
                    arr[0].Price+=15000;
                    break;
                }

                case "6":
                {
                    System.out.println("added to cart the  laptop that costs a 20000rs. "+"\n");
                    arr[0].items+="laptop, "; 
                    arr[0].Price+=20000;
                    break;
                }

                case "7":
                {
                    System.out.println("added to cart the  washing machine that costs a 25000rs. "+"\n");
                    arr[0].items+="washing machine, "; 
                    arr[0].Price+=25000;
                    break;
                }

                case "8":
                {
                    System.out.println("added to cart the  hade phone that costs a 1000rs. "+"\n");
                    arr[0].items+="hade phone, ";
                    arr[0].Price+=1000;
                    break;
                }

                case "9":
                {
                    System.out.println("added to cart the  trimmer that costs a 1100rs. "+"\n");
                    arr[0].items+="trimmer, ";
                    arr[0].Price+=1100;
                    break;
                }

                case "10":
                {
                    System.out.println("added to cart the  hair dryer that costs a 800rs. "+"\n");
                    arr[0].items+="hair dryer, ";
                    arr[0].Price+=800;
                    break;
                }

                case "11":
                {
                    System.out.print("you bougth a total of so many items :- ");
                    System.out.println(arr[0].items+"\n\n");

                    System.out.print("this is the cost of all electronics deviceses :- ");
                    System.out.println(arr[0].Price+"\n\n");

                    return ;
                } 

                default :
                {
                    System.out.println("invalid choice pls try again :- "+"\n");
                }

            }
        }
    }
}
class ECommerce3 extends ECommerce2
{
    void homelivingitemes()
    {
        Scanner scn=new Scanner(System.in);

        while(true)
        {
            System.out.println("Choose an item to add to your cart:");
            System.out.println("1. Small Temple (Rs 600)");
            System.out.println("2. Kitchen Set (Rs 8000)");
            System.out.println("3. Sofa Set (Rs 9000)");
            System.out.println("4. Pillows (Rs 200)");
            System.out.println("5. Dining Set (Rs 10000)");
            System.out.println("6. Painting (Rs 600)");
            System.out.println("7. Table (Rs 6000)");
            System.out.println("8. TV Stand (Rs 5000)");
            System.out.println("9. Mirror (Rs 500)");
            System.out.println("10. Shampoo (Rs 200)");
            System.out.println("11. Exit Home Living Menu \n");

            System.out.print("enter a sequence number :- ");
            String sk=scn.nextLine();

            switch(sk) 
            {
                case "1":
                {
                    System.out.println("Added to cart the small temple that costs rs.600."+"\n");
                    arr[1].items += "small temple, ";
                    arr[1].Price += 600;
                    break;
                }

                case "2":
                {
                    System.out.println("Added to cart the kitchen set that costs rs.8000."+"\n");
                    arr[1].items += "kitchen set, ";
                    arr[1].Price += 8000;
                    break;
                }

                case "3":
                {
                    System.out.println("Add to cart the sofa set that costs rs.9000."+"\n");
                    arr[1].items += "sofa set, ";
                    arr[1].Price += 9000;
                    break;
                }

                case "4":
                {
                    System.out.println("Add to cart the Pillows that costs rs.200."+"\n");
                    arr[1].items += "Pillows, ";
                    arr[1].Price += 200;
                    break;
                }

                case "5":
                {
                    System.out.println("Add to cart the Dining Set that costs rs.10000."+"\n");
                    arr[1].items += "Dining Set, ";
                    arr[1].Price += 10000;
                    break;
                }

                case "6":
                {
                    System.out.println("Add to cart the painting that costs rs.600."+"\n");
                    arr[1].items += "painting, ";
                    arr[1].Price += 600;
                    break;
                }

                case "7":
                {
                    System.out.println("Add to cart the table that costs rs.6000."+"\n");
                    arr[1].items += "table, ";
                    arr[1].Price += 6000;
                    break;
                }

                case "8":
                {
                    System.out.println("Add to cart the tv stand that costs rs.5000."+"\n");
                    arr[1].items += "tv stand, ";
                    arr[1].Price += 5000;
                    break;
                }

                case "9":
                {
                    System.out.println("Add to cart the mirror that costs rs.500."+"\n");
                    arr[1].items += "mirror, ";
                    arr[1].Price += 500;
                    break;
                }

                case "10":
                {
                    System.out.println("Add to cart the shampoo that costs rs.200."+"\n");
                    arr[1].items += "shampoo, ";
                    arr[1].Price += 200;
                    break;
                }

                case "11":
                {
                    System.out.print("you bouth a total of so many items :- ");
                    System.out.println(arr[1].items+"\n\n");

                    System.out.print("this is the cost of all home living  devices :- ");
                    System.out.println(arr[1].Price+"\n\n");

                    return ;
                }

                default:
                {
                    System.out.println("Invalid selection."+"\n");
                }

            }
        }
    }
}
class ECommerce4 extends ECommerce3
{
    void vegetablesfruitsitems()
    {
        Scanner scn=new Scanner(System.in);

        for( ; true ; )
        {
            System.out.println("Choose an item to add to your cart:");
            System.out.println("1. Potatoes (Rs 10/kg)");
            System.out.println("2. Flowers (Rs 30/kg)");
            System.out.println("3. Tomatoes (Rs 20/kg)");
            System.out.println("4. Capsicums (Rs 60/kg)");
            System.out.println("5. Bananas (Rs 40/kg)");
            System.out.println("6. Apples (Rs 20/kg)");
            System.out.println("7. Strawberries (Rs 100/kg)");
            System.out.println("8. Beets (Rs 150/kg)");
            System.out.println("9. Oranage (Rs 100/kg)");
            System.out.println("10. Mangoes (Rs 1200/kg)");
            System.out.println("11. Exit Fruits and Vegetables Menu \n");

            System.out.print("enter a sequence number :- ");
            String sk=scn.nextLine();

            switch (sk) 
            {
                case "1":
                {
                    System.out.println("Add to cart the  Potatoes  that costs rs.10/kg."+"\n");
                    arr[2].items += "Potatoes, ";
                    arr[2].Price += 10;
                    break;
                }

                case "2":
                {
                    System.out.println("Add to cart the  Flower  that costs rs.30/kg."+"\n");
                    arr[2].items += "Flower, ";
                    arr[2].Price += 30;
                    break;
                }

                case "3":
                {
                    System.out.println("Add to cart the  Tomatoes  that costs rs.20/kg."+"\n");
                    arr[2].items += "Tomatoes, ";
                    arr[2].Price += 20;
                    break;
                }

                case "4":
                {
                    System.out.println("Add to cart the  Capsicums  that costs rs.60/kg  "+"\n");
                    arr[2].items += "Capsicums, ";
                    arr[2].Price += 60;
                    break;
                }

                case "5":
                {
                    System.out.println("Add to cart the  Banana  that costs rs.40/kg."+"\n");
                    arr[2].items += "Banana, ";
                    arr[2].Price += 40;
                    break;
                }

                case "6":
                {
                    System.out.println("Add to cart the  Apple  that costs rs.20/kg."+"\n");
                    arr[2].items += "Apple, ";
                    arr[2].Price += 20;
                    break;
                }

                case "7":
                {
                    System.out.println("Add to cart the  Strawberries  that costs rs.100/kg."+"\n");
                    arr[2].items += "Strawberries, ";
                    arr[2].Price += 100;
                    break;
                }

                case "8":
                {
                    System.out.println("Add to cart the  Beets  that costs rs.150/kg."+"\n");
                    arr[2].items += "Beets, ";
                    arr[2].Price += 150;
                    break;
                }    

                case "9":
                {
                    System.out.println("Add to cart the  Orange  that costs rs.100/kg."+"\n");
                    arr[2].items += "Orange, ";
                    arr[2].Price += 100;
                    break;
                }

                case "10":
                {
                    System.out.println("Add to cart the  Mango  that costs rs.1200/kg."+"\n");
                    arr[2].items += "Mango, ";
                    arr[2].Price += 1200;
                    break;
                }

                case "11" :
                {
                    System.out.print("You bought a total of these items:");
                    System.out.println(arr[2].items+"\n\n");

                    System.out.print("The total cost of all vegetables and fruits is:");
                    System.out.println(arr[2].Price+"\n\n");

                    return ;
                }

                default:
                {
                    System.out.println("Invalid option. Please select a valid item number."+"\n");
                }

            }
        }
    }
}
class ECommerce5 extends ECommerce4
{
    void snekssweetsitems()
    {
        Scanner scn=new Scanner(System.in);

        while(true)
        {
            System.out.println("1. Ice Cream (Rs 30/100g)");
            System.out.println("2. Chips (Rs 10/100g)");
            System.out.println("3. Coca-Cola (Rs 20/100ml)");
            System.out.println("4. Chocolates (Rs 60/100g)");
            System.out.println("5. Mazza (Rs 40/500ml)");
            System.out.println("6. Biscuits (Rs 20/100g)");
            System.out.println("7. Maggi (Rs 60/200g)");
            System.out.println("8. Gulab Jamun (Rs 300/kg)");
            System.out.println("9. Rasgullas (Rs 400/kg)");
            System.out.println("10. Badams (Rs 100/100g)");
            System.out.println("11. Exit Fruits and Vegetables Menu \n");

            System.out.print("enter a sequence number :- ");
            String sk=scn.nextLine();

            switch (sk) 
            {
                case "1": 
                {
                    System.out.println("Add to cart the  Ice Cream  that costs rs.30/100g."+"\n");
                    arr[3].items += "Ice Cream, ";
                    arr[3].Price += 30;
                    break;
                }

                case "2": 
                {
                    System.out.println("Add to cart the  Chips  that costs rs.10/100g."+"\n");
                    arr[3].items += "Chips, ";
                    arr[3].Price += 10;
                    break;
                }

                case "3": 
                {
                    System.out.println("Add to cart the  Coca-Cola  that costs rs.20/100ml."+"\n");
                    arr[3].items += "Coca-Cola, ";
                    arr[3].Price += 20;
                    break;
                }

                case "4": 
                {
                    System.out.println("Add to cart the  Chocolates  that costs rs.60/100g."+"\n");
                    arr[3].items += "Chocolates, ";
                    arr[3].Price += 60;
                    break;
                }

                case "5": 
                {
                    System.out.println("Add to cart the  Mazza  that costs rs.40/500ml."+"\n");
                    arr[3].items += "Mazza, ";
                    arr[3].Price += 40;
                    break;
                }

                case "6": 
                {
                    System.out.println("Add to cart the  Biscuits  that costs rs.20/100g."+"\n");
                    arr[3].items += "Biscuits, ";
                    arr[3].Price += 20;
                    break;
                }

                case "7": 
                {
                    System.out.println("Add to cart the  Maggi  that costs rs.60/200g."+"\n");
                    arr[3].items += "Maggi, ";
                    arr[3].Price += 60;
                    break;
                }

                case "8": 
                {
                    System.out.println("Add to cart the  Gulab Jamun  that costs rs.300/kg."+"\n");
                    arr[3].items += "Gulab Jamun, ";
                    arr[3].Price += 300;
                    break;
                }

                case "9": 
                {
                    System.out.println("Add to cart the  Rasgollas  that costs rs.400/kg."+"\n");
                    arr[3].items += "Rasgullas, ";
                    arr[3].Price += 400;
                    break;
                }

                case "10": 
                {
                    System.out.println("Add to cart the  Fruits  that costs rs.100/100g."+"\n");
                    arr[3].items += "Badams, ";
                    arr[3].Price += 100;
                    break;
                }

                case "11": 
                {
                    System.out.print("You bought a total of these items:");
                    System.out.println(arr[3].items+"\n\n");
                    System.out.print("The total cost of all snacks and sweets items is:");
                    System.out.println(arr[3].Price+"\n\n");
                    
                    return ;
                }

                default: 
                {
                    System.out.println("Invalid option. Please select a valid item number."+"\n");
                }
            }
        }
    }
}
class games 
{
    Scanner scn=new Scanner(System.in);
    double RockPaperScissor(double totalcost) 
    {
        String[] usechoices={"1" , "2" , "3" };
        
        int userpoints=0;
        int computerpoints=0;

        for(int i=1; i<=5 ; i++)
        {
            int randomIndex = (int)(Math.random() * 3);
            String computerChoice=usechoices[randomIndex];

            System.out.println(i+" so many rounds are going on "+"\n");

            System.out.print("Enter your choice (1.Rock, 2.Paper, 3.Scissor or 4.Exit):==  ");
            String userenter = scn.nextLine();

            if(userenter.equalsIgnoreCase("1")  && computerChoice.equalsIgnoreCase("1") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("match is tie ");
                System.out.println("\n");
                i--;
            }

            else if(userenter.equalsIgnoreCase("2") && computerChoice.equalsIgnoreCase("2") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("match is tie ");
                System.out.println("\n");
                i--;
            }

            else if(userenter.equalsIgnoreCase("3") && computerChoice.equalsIgnoreCase("3") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("match is tie ");
                System.out.println("\n");
                i--;
            }

            else if(userenter.equalsIgnoreCase("1") && computerChoice.equalsIgnoreCase("2") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have lost this round ");
                computerpoints+=1;
                System.out.println("\n");
            }

            else if(userenter.equalsIgnoreCase("2") && computerChoice.equalsIgnoreCase("1") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have won this round ");
                userpoints+=1;
                System.out.println("\n");
            }

            else if(userenter.equalsIgnoreCase("2") && computerChoice.equalsIgnoreCase("3") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have lost this round ");
                computerpoints+=1;
                System.out.println("\n");
            }

            else if(userenter.equalsIgnoreCase("3")  && computerChoice.equalsIgnoreCase("2") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have won this round ");
                userpoints+=1;
                System.out.println("\n");
            }

            else if(userenter.equalsIgnoreCase("3")  && computerChoice.equalsIgnoreCase("1") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have lost this round ");
                computerpoints+=1;
                System.out.println("\n");
            }

            else if(userenter.equalsIgnoreCase("1")  && computerChoice.equalsIgnoreCase("3") )
            {
                System.out.println("computer is selected :- "+computerChoice);
                System.out.println("you have won this round ");
                userpoints+=1;
                System.out.println("\n");
            }

            else 
            {
                System.out.println("invalid choice");
                i--;
            }

            if(userenter.equalsIgnoreCase("4"))
            {
                System.out.println("user point's is  "+userpoints);
                System.out.println("computer points is "+computerpoints);
                break;
            }

        }

        if(userpoints>3)
        {
            System.out.println("you won the game ");
            System.out.println("your score is "+userpoints);
            System.out.println("You still get 15% discount congratulations ");
            totalcost -= totalcost*0.15;
        }

        else 
        {
            System.out.println("Sorry you loss the game ");
            System.out.println("your score is "+userpoints);
        }

        return totalcost;
    }

    double choosethenumber(double totalcost)
    {
        int rendom = (int) (Math.random() * 10);

        System.out.println("enter a rendom number :- ");
        int userenter=scn.nextInt();
        System.out.println("computr choose the "+rendom);

        if(rendom==userenter)
        {
            System.out.println("You still get 15% discount congratulations ");
            totalcost -= totalcost*0.15;
        }

        else 
        {
            System.out.println("Sorry you loss the game ");
        }

        return totalcost;
    }
}

class TicTecToe 
{
    double hellow(double totalcost) 
    {
        int win=0;
        int los=0;

        char[][] arr = new char[3][3];

        for (int row = 0; row < arr.length; row++) 
        {
            for (int col = 0; col < arr[row].length; col++) 
            {
                arr[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        for (int turn = 1; !gameOver; turn++) 
        {
            int row = -1;
            int col = -1;
            

            if (turn % 2 != 0) 
            {
                printarr(arr);
                System.out.print("Player X, enter your move (row and column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                System.out.println();
            } 

            else 
            {
                printarr(arr);
                System.out.println("Player O (computer) is making a move...");

                do 
                {
                    row = (int) (Math.random() * 3);
                    col = (int) (Math.random() * 3);
                } 
                while (arr[row][col] != ' ');

                System.out.println("Computer chose: " + row + " " + col);
            }

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && arr[row][col] == ' ') 
            {
                arr[row][col] = player;
                gameOver = haveWon(arr, player);

                if (gameOver) 
                {
                    printarr(arr);
                    if(player=='X')
                    {
                        System.out.println("Player " + player + " has won!");
                        win++;
                        
                    }

                    else
                    {
                        System.out.println("Player " + player + " has won!");
                        los++;
                        
                    }
                    
                } 
                else if (isarrFull(arr)) 
                {
                    printarr(arr);
                    System.out.println("It's a draw!");
                    break;
                } 

                else 
                {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } 
            else 
            {
                System.out.println("Invalid move. Try again!");
                turn--;
            }
        }
        if(win==1)
        {
            totalcost-=totalcost*0.15;
            return totalcost;
        }
        else
        {
            return totalcost;
        }
    }

    public static boolean haveWon(char[][] arr, char player) 
    {
        for (int row = 0; row < arr.length; row++) 
        {
            if (arr[row][0] == player && arr[row][1] == player && arr[row][2] == player) 
            {
                return true;
            }
        }
        for (int col = 0; col < arr[0].length; col++) 
        {
            if (arr[0][col] == player && arr[1][col] == player && arr[2][col] == player) 
            {
                return true;
            }
        }
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) 
        {
            return true;
        }
        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) 
        {
            return true;
        }
        return false;
    }

    public static boolean isarrFull(char[][] arr) 
    {
        for (int row = 0; row < arr.length; row++) 
        {
            for (int col = 0; col < arr[row].length; col++) 
            {
                if (arr[row][col] == ' ') 
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printarr(char[][] arr) 
    {
        for (int row = 0; row < arr.length; row++) 
        {
            for (int col = 0; col < arr[row].length; col++) 
            {
                System.out.print(arr[row][col]);

                if (col < arr[row].length - 1) 
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            
            if (row < arr.length - 1) 
            {
                System.out.println("---------");
            }
        }
    }
}