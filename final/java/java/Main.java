import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

public class Main
{
    String temp = null;
    Scanner sc = new Scanner( System.in );
    ArrayList<Contact> myList = new ArrayList<Contact>( );
    ArrayList<Contact> temp_list = new ArrayList<Contact>( );
    Contact person = null;
    boolean b_number = true, b_name = true, b_phone = true,b_email = true,b_address = true, b_type = true, b_birthday = true;
    String writefile="";
    String loadfile="";

    public static void main( String[] args )
    {
        Main demo = new Main();

        demo.login();

        demo.load_contact( );

        demo.welcome();

    }



    // 登入系統
    public void login()
    {
        String account = null, password = null;
        int i=0;
        do {
            i++;
            System.out.print( "帳號：" );
            account = sc.next();
            System.out.print( "密碼：" );
            password = sc.next();

            if( account.equals("cis") && password.equals("1234") )
            {
                System.out.println( "登入成功！" );

            }

            else{
                System.out.printf( "帳號或密碼錯誤！ 請重新輸入！\n\n" );
                System.out.println( "錯誤三次即會離開系統(" + i + "/3)\n" );}
            if( i == 3){
                System.out.println( "已關閉系統！" );
                System.exit( 0 );
            }
        }
        while ( !( account.equals("cis") && password.equals("1234") ) );
    }


    // 讀取人庫
    public void load_contact( )
    {
        Scanner load = null;
        try
        {   System.out.println("請輸入要讀取之資料");
            loadfile=sc.next()+".txt";
            load = new Scanner( new FileInputStream(  loadfile ) );
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File contact.txt was addresst found");
            System.out.println("or could addresst be opened.");
            System.exit(0);
        }

        String name = null, phone = null, email = null, address = null, type = null, birthday = null;

        temp = load.nextLine( );
        temp = load.nextLine( );
        while( load.hasNext( ) ) {
            name = load.next( );
            phone = load.next( );
            email = load.next( );
            address = load.next( );
            type = load.next( );
            birthday = load.next( );
            person = new Contact( name, phone, email, address, type, birthday );
            myList.add( person );
        }


        load.close( );
    }


    // 主選單
    public void welcome( )
    {
        System.out.println("\n請輸入欲執行功能之代碼：");
        System.out.println("1.管理功能　　　　　　2.使用者功能　　　　　3.結束");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                control( );
            else if (  temp.equalsIgnoreCase("2") )
                user( );
            else if(  temp.equalsIgnoreCase("3") ) {
                store_contact( );
                System.out.println( "已關閉系統！" );
                System.exit( 0 );
            }
            else {
                System.out.println("輸入錯誤！ 請重新輸入欲執行功能之代碼：");
                temp = sc.next();
            }
        }
    }


    // 管理功能選單
    public void control( )
    {
        System.out.println("\n請輸入欲執行功能之代碼：");
        System.out.println("1.設定可顯示的欄位　　2.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                set_display( );
            else if(  temp.equalsIgnoreCase("2") )
                welcome( );
            else {
                System.out.println("\n輸入錯誤！ 請重新輸入欲執行功能之代碼：");
                System.out.println("1.設定可顯示的欄位　　2.上一頁");
                temp = sc.next();
            }
        }
    }


    // 設定哪些欄位要顯示
    public void set_display( )
    {
        System.out.println("\n請選擇各欄位是否要顯示(輸入Y/N)：");


        System.out.print("排序：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_number = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_number = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("姓名：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_name = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_name = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("電話號碼：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_phone = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_phone = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("e-mail：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_email = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_email = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("分類：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_type = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_type = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("生日：");
        temp = sc.next( );
        while( true )
            if( temp.substring( 0, 1 ).equalsIgnoreCase( "Y" ) ) {
                b_birthday = true;
                break;
            }
            else if( temp.substring( 0, 1 ).equalsIgnoreCase( "N" ) ) {
                b_birthday = false;
                break;
            }
            else {
                System.out.print("輸入錯誤！ 請重新輸入：");
                temp = sc.next( );
            }

        System.out.print("\n設定成功！　");
        print_enter( );
        control( );
    }


    // 使用者功能選單
    public void user( )
    {
        System.out.println("\n請輸入欲執行功能之代碼：");
        System.out.println("1.新增　　　　　　　　2.查詢　　　　　　　　3.修改");
        System.out.println("4.刪除　　　　　　　　5.顯示　　　　　　　　6.保存/覆蓋");
        System.out.println("0.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                add_contact( );
            else if(  temp.equalsIgnoreCase("2") )
                search_contact( );
            else if(  temp.equalsIgnoreCase("3") )
                edit_contact( );
            else if(  temp.equalsIgnoreCase("4") )
                delete_contact( );
            else if(  temp.equalsIgnoreCase("5") )
                display( );
            else if(  temp.equalsIgnoreCase("6") ){
                    writefile_contact( );

                System.out.print( "\n儲存成功！　" );
                print_enter( );
                welcome( );
            }
            else if(  temp.equalsIgnoreCase("0") )
                welcome( );
            else {
                System.out.println("\n輸入錯誤！ 請重新輸入欲執行功能之代碼：");
                System.out.println("1.新增　　　　　　　　2.查詢　　　　　　　　3.修改");
                System.out.println("4.刪除　　　　　　　　5.顯示　　　　　　　　6.保存/覆蓋");
                System.out.println("0.上一頁");
                temp = sc.next();
            }
        }
    }
    //保存/覆蓋
    public void writefile_contact( ){

        System.out.println( "請輸入要寫入的檔案名稱，若重複則覆寫" );
        writefile=sc.next()+".txt";

    }

    // 新增項目
    public void add_contact( )
    {
        person = new Contact( );

        System.out.println("\n請輸入欲新增的姓名：");
        temp = sc.next( );
        while( !person.setName( temp ) )
            temp = sc.next( );

        System.out.println("\n請輸入此人的電話號碼：");
        temp = sc.next( );
        while( !person.setPhone( temp ) )
            temp = sc.next( );

        System.out.println("\n請輸入此人的e-mail：");
        temp = sc.next( );
        while( !person.setEmail( temp ) )
            temp = sc.next( );

        System.out.println("\n請輸入此人的住址：");
        temp = sc.next( );
        while( !person.setAddress( temp ) )
            temp = sc.next( );

        System.out.println("\n請選擇此人分類：");
        System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
        System.out.println("4.網友　　　　　　　5.其他");
        boolean b = true;
        temp = sc.next( );
        while( b )
            switch( temp ) {
                case "1":
                    person.setType( "同學" ); b = false; break;
                case "2":
                    person.setType( "朋友" ); b = false; break;
                case "3":
                    person.setType( "家人" );  b = false; break;
                case "4":
                    person.setType( "網友" );   b = false; break;
                case "5":
                    person.setType( "其他" ); b = false; break;
                default:
                    System.out.println("輸入錯誤！請重新選擇欲新增的連絡人分類：");
                    System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
                    System.out.println("4.網友　　　　　　　5.其他");
                    temp = sc.next( );
            }

        System.out.println("\n請輸入欲新增的生日：");
        temp = sc.next( );
        while( !person.setBirthday( temp ) )
            temp = sc.next( );

        myList.add( person );

        display_all_name( );
        System.out.printf( " %-5d", myList.size( ) );
        display_all_elements( myList.size( ) - 1 );
        System.out.print("\n新增成功!　");
        print_enter( );
        user( );
    }


    // 查人
    public void search_contact( )
    {
        int x = 0;

        System.out.println("\n請輸入欲查詢的姓名資料欄位：");
        System.out.println("1.姓名　　　　　　　　2.電話號碼　　　　　　3.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                x = 0;
                System.out.println("\n請輸入欲查姓名的姓名：");
                temp = sc.next();
                for( int i = 0 ; i < myList.size( ) ; i++ ) {
                    if(   myList.get( i ).getName( ).contains(temp) ) {
                        if( x == 0 )
                            display_all_name( );
                        System.out.printf( " %-5d", i );
                        display_all_elements( i );
                        x++;
                    }
                }

                if( x == 0 )
                    System.out.println( "無此人！" );

                System.out.println( );
                print_enter( );

                user( );
            }

            else if(  temp.equalsIgnoreCase("2") ) {
                x = 0;
                System.out.println("\n請輸入此人的電話號碼：");
                temp = sc.next();
                for( int i = 0 ; i < myList.size( ) ; i++ ) {
                    if(  temp.equalsIgnoreCase( myList.get( i ).getPhone( ) ) ) {
                        if( x == 0 )
                            display_all_name( );
                        System.out.printf( " %-5d", i );
                        display_all_elements( i );
                        x++;
                    }
                }

                if( x == 0 )
                    System.out.println( "無此電話號碼！" );

                System.out.println( );
                print_enter( );

                user( );
            }

            else if (  temp.equalsIgnoreCase("3") )
                user( );

            else {
                System.out.println("\n輸入錯誤！ 請重新輸入欲查詢的連絡人欄位：");
                System.out.println("1.姓名　　　　　　　　2.電話號碼　　　　　　3.上一頁");
                temp = sc.next();
            }
        }
    }


    // 修改資料欄位
    public void edit_contact( )
    {
        System.out.println("\n請輸入欲修改的人本排序號(輸入0則回到上一頁)：");

        int number = sc.nextInt( );
        while( number > 0 ) {
            if( number > myList.size( ) ) {
                System.out.println("無此排序！請重新輸入欲修改的連絡人排序(輸入0則回到上一頁)：");
                number = sc.nextInt( );
                continue;
            }
            number--;

            System.out.println( "欲修改的人資料：" );
            display_all_elements( number );

            System.out.println("\n請選擇欲修改的連絡人欄位：");
            System.out.println("1.姓名　　　　　　　　2.電話號碼　　　　　　　　3.e-mail");
            System.out.println("4.住址　　　　　　　　5.類別                 6.生日");
            temp = sc.next();
            while( true ) {
                if(  temp.equalsIgnoreCase("1") ) {
                    System.out.println("\n請輸入新的姓名：");
                    temp = sc.next( );
                    while( !myList.get( number ).setName( temp ) )
                        temp = sc.next( );
                }


                else if(  temp.equalsIgnoreCase("2") ) {
                    System.out.println("\n請輸入本人的電話號碼：");
                    temp = sc.next( );
                    while( !myList.get( number ).setPhone( temp ) )
                        temp = sc.next( );
                }
                else if(  temp.equalsIgnoreCase("3") ) {
                    System.out.println("\n請輸入本人的e-mail：");
                    temp = sc.next( );
                    while( !myList.get( number ).setEmail( temp ) )
                        temp = sc.next( );
                }

                else if(  temp.equalsIgnoreCase("4") ) {
                    System.out.println("\n請輸入本人住址：");
                    temp = sc.next( );
                    while( !myList.get( number ).setAddress( temp ) )
                        temp = sc.next( );
                }
                else if(  temp.equalsIgnoreCase("5") ) {
                    System.out.println("\n請選擇新的連絡人分類：");
                    System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
                    System.out.println("4.網友　　　　　　　5.其他");
                    boolean b = true;
                    temp = sc.next( );
                    while( b )
                        switch( temp ) {
                            case "1":
                                myList.get( number ).setType( "同學" );   b = false; break;
                            case "2":
                                myList.get( number ).setType( "朋友" );   b = false; break;
                            case "3":
                                myList.get( number ).setType( "家人" );    b = false; break;
                            case "4":
                                myList.get( number ).setType( "網友" ); b = false; break;
                            case "5":
                                myList.get( number ).setType( "其他" );   b = false; break;
                            default:
                                System.out.println("輸入格式錯誤！請重新選擇新的此人分類：");
                                System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
                                System.out.println("4.網友　　　　　　　5.其他");
                                temp = sc.next( );
                        }
                }

                else if(  temp.equalsIgnoreCase("6") ) {
                    System.out.println("\n請輸入此人生日：");
                    temp = sc.next( );
                    while( !myList.get( number ).setBirthday( temp ) )
                        temp = sc.next( );
                }

                else {
                    System.out.println("\n輸入錯誤！ 請重新選擇欲修改的連絡人欄位：");
                    System.out.println("1.姓名　　　　　　　　2.電話號碼　　　　　　　　3.e-mail");
                    System.out.println("4.住址　　　　　　　　5.分類                 6.生日");
                    temp = sc.next();
                }

                display_all_name( );
                System.out.printf( " %-5d", number );
                display_all_elements( number );
                System.out.print("\n修改成功！　");
                print_enter( );
                break;
            }
            user( );
        }

        user( );
    }


    // 刪除人目
    public void delete_contact( )
    {
        System.out.println("\n請輸入欲刪除的人本排序號(輸入0則回到上一頁)：");

        int number = sc.nextInt( );
        while( number > 0 ) {
            if( number > myList.size( ) ) {
                System.out.println("無此排序！請重新輸入欲刪除的人本排序號(輸入0則回到上一頁)：");
                number = sc.nextInt( );
                continue;
            }

            display_all_name( );
            System.out.printf( " %-5d", --number );
            display_all_elements( number );
            myList.remove( number );

            System.out.print("\n刪除成功！　");
            print_enter( );
            break;
        }

        user( );
    }


    // 顯示
    public void display( )
    {
        System.out.println("\n請選擇顯示方式：");
        System.out.println("1.所有分類　　　　　　2.單一分類　　　　　　0.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                display_all( );
            else if(  temp.equalsIgnoreCase("2") )
                display_type( );
            else if(  temp.equalsIgnoreCase("0") )
                user( );
            else {
                System.out.println("\n輸入格式錯誤！ 請重新選擇顯示方式：");
                System.out.println("1.所有分類　　　　　　2.單一分類　　　　　　0.上一頁");

                temp = sc.next();
            }
        }
    }


    // 顯示所有分類
    public void display_all( )
    {
        System.out.println("\n請選擇顯示方式：");
        System.out.println("1.顯示所有資料　　　　2.分頁顯示　　　　　　3.顯示所有資料(依生日排序)");
        System.out.println("0.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                System.out.println( );
                display_name( );
                for( int i = 0 ; i < myList.size( ) ; i++ )
                    display_elements( i );
                System.out.println( );
                print_enter( );

                user( );
            }
            else if(  temp.equalsIgnoreCase("2") )
                display_all_page( );
            else if(  temp.equalsIgnoreCase("3") )
                display_all_sort( );
            else if(  temp.equalsIgnoreCase("0") )
                display( );

            else {
                System.out.println("\n輸入格式錯誤！ 請重新選擇顯示方式：");
                System.out.println("1.顯示所有資料　　　　2.分頁顯示　　　　　　0.上一頁");
                temp = sc.next();
            }
        }
    }
    public void display_all_sort() {

        System.out.println( );

        display_name( );
        String temp="";
        for (int k=0 ;k<myList.size( );k++) {
            for (int i=0 ;i<myList.size( )-1;i++) {
                if (myList.get(i+1).birthday.compareTo(myList.get(i).birthday)<0) {
                    temp = myList.get(i).name;
                    myList.get(i).name = myList.get(i + 1).name;
                    myList.get(i + 1).name = temp;

                    temp = myList.get(i).phone;
                    myList.get(i).phone = myList.get(i + 1).phone;
                    myList.get(i + 1).phone = temp;

                    temp =myList.get(i).address;
                    myList.get(i).address = myList.get(i + 1).address;
                    myList.get(i + 1).address = temp;

                    temp = myList.get(i).email;
                    myList.get(i).email = myList.get(i + 1).email;
                    myList.get(i + 1).email = temp;

                    temp = myList.get(i).type;
                    myList.get(i).type = myList.get(i + 1).type;
                    myList.get(i + 1).type =temp;

                    temp = myList.get(i).birthday;
                    myList.get(i).birthday = myList.get(i + 1).birthday;
                    myList.get(i + 1).birthday = temp;


                }

            }
        }

        for( int i = 0 ; i < myList.size( ) ; i++ )
        {
            display_elements( i );

        }




        print_enter( );

        user( );

    }
    // 所有分類分頁顯示
    public void display_all_page( )
    {
        int i, k, page = 1;

        System.out.println( );
        display_name( );
        for( i = 0 ; i < 10 ; i++ ) {
            if( i < myList.size( ) )
                display_elements( i );
            else
                System.out.println( );
        }
        System.out.println( );
        System.out.println("1.上一頁　　　　　　　2.下一頁　　　　3.自行輸入頁碼");
        System.out.println("0.回到使用者功能選單");

        temp = sc.next( );
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                if( page == 1 )
                    System.out.println("\n此為第一頁！　請重新選擇：");

                else {
                    page--;
                    System.out.println( );
                    display_name( );
                    for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                        if( i < myList.size( ) )
                            display_elements( i );
                        else
                            System.out.println( );
                    }
                    System.out.println( );
                }
            }

            else if(  temp.equalsIgnoreCase("2") ) {
                if( page * 10 >= myList.size( )  )
                    System.out.println("\n此為最後一頁！　請重新選擇：");

                else {
                    page++;
                    System.out.println( );
                    display_name( );
                    for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                        if( i < myList.size( ) )
                            display_elements( i );
                        else
                            System.out.println( );
                    }
                    System.out.println( );
                }
            }

            else if(  temp.equalsIgnoreCase("3") ) {
                System.out.println( "\n請輸入欲瀏覽之頁碼：" );
                page = sc.nextInt( );
                while( ( myList.size( ) - 1 ) - ( page - 1 ) * 10 < 0 ) {
                    System.out.println( "無此頁碼！ 請重新輸入欲瀏覽之頁碼：" );
                    page = sc.nextInt( );
                }

                System.out.println( );
                display_name( );
                for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                    if( i < myList.size( ) )
                        display_elements( i );
                    else
                        System.out.println( );
                }
                System.out.println( );
            }

            else if(  temp.equalsIgnoreCase("0") )
                user( );


            System.out.println("1.上一頁　　　　　　　2.下一頁　　　　3.自行輸入頁碼");
            System.out.println("0.回到使用者功能選單");
            temp = sc.next( );
        }
    }

    // 單一分類顯示
    public void display_type( )
    {
        int i;
        String type;
        boolean b = true;

        System.out.println("\n請選擇欲顯示的連絡人分類：");
        System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
        System.out.println("4.網友　　　　　　　5.其他");

        type = sc.next( );
        while( b )
            switch( type ) {
                case "1":
                    type = "同學";    b = false; break;
                case "2":
                    type = "朋友";    b = false; break;
                case "3":
                    type = "家人"; b = false; break;
                case "4":
                    type = "網友";  b = false; break;
                case "5":
                    type = "其他";       b = false; break;
                default:
                    System.out.println("輸入錯誤！請重新選擇新的連絡人分類：");
                    System.out.println("1.同學　　　　　　　2.朋友　　　　　　　3.家人");
                    System.out.println("4.網友　　　　　　　5.其他");
                    type = sc.next( );
            }

        temp_list.clear( );
        for( i = 0 ; i < myList.size( ) ; i++ ) {
            if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
                temp_list.add( myList.get( i ) );
        }
        if( temp_list.size( ) == 0 ) {
            System.out.println( "\n無此分類的姓名！" );
            System.out.println( );
            print_enter( );
            display_type( );
        }

        System.out.println("\n請選擇顯示方式：");
        System.out.println("1.顯示所有此分類資料　2.分頁顯示　　　　　　3.上一頁");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                System.out.println( );
                display_name( );
                for( i = 0 ; i < myList.size( ) ; i++ ) {
                    if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
                        display_elements( i );
                }
                System.out.println( );
                print_enter( );

                user( );
            }
            else if(  temp.equalsIgnoreCase("2") )
                display_type_page( );
            else if(  temp.equalsIgnoreCase("3") )
                display( );
            else {
                System.out.println("\n輸入錯誤！ 請重新選擇顯示方式：");
                System.out.println("1.顯示所有此分類資料　2.分頁顯示　　　　　　3.上一頁");
                temp = sc.next();
            }
        }
    }


    // 單一分類分頁顯示
    public void display_type_page( )
    {
        int i, k, page = 1;

        System.out.println( );
        display_name( );
        for( i = 0 ; i < 10 ; i++ ) {
            if( i < temp_list.size( ) )
                display_elements_for_type( i );
            else
                System.out.println( );
        }
        System.out.println( );
        System.out.println("1.上一頁　　　　　　　2.下一頁　　　　3.自行輸入頁碼");
        System.out.println("4.回到使用者功能選單");

        temp = sc.next( );
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                if( page == 1 )
                    System.out.println("\n此為第一頁！　請重新選擇：");

                else {
                    page--;
                    System.out.println( );
                    display_name( );
                    for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                        if( i < temp_list.size( ) )
                            display_elements_for_type( i );
                        else
                            System.out.println( );
                    }
                    System.out.println( );
                }
            }

            else if(  temp.equalsIgnoreCase("2") ) {
                if( page * 10 >= temp_list.size( )  )
                    System.out.println("\n此為最後一頁！　請重新選擇：");

                else {
                    page++;
                    System.out.println( );
                    display_name( );
                    for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                        if( i < temp_list.size( ) )
                            display_elements_for_type( i );
                        else
                            System.out.println( );
                    }
                    System.out.println( );
                }
            }

            else if(  temp.equalsIgnoreCase("3") ) {
                System.out.println( "\n請輸入欲瀏覽之頁碼：" );
                page = sc.nextInt( );
                while( ( temp_list.size( ) - 1 ) - ( page - 1 ) * 10 < 0 ) {
                    System.out.println( "無此頁碼！ 請重新輸入欲瀏覽之頁碼：" );
                    page = sc.nextInt( );
                }

                System.out.println( );
                display_name( );
                for( i = ( page - 1 ) * 10, k = 0 ; k < 10 ; i++, k++ ) {
                    if( i < temp_list.size( ) )
                        display_elements_for_type( i );
                    else
                        System.out.println( );
                }
                System.out.println( );
            }

            else if(  temp.equalsIgnoreCase("4") )
                user( );


            System.out.println("1.上一頁　　　　　　　2.下一頁　　　　3.自行輸入頁碼");
            System.out.println("4.回到使用者功能選單");
            temp = sc.next( );
        }
    }


    // 控制顯示時的欄位for特定分類分頁顯示
    public void display_elements_for_type( int i )
    {
        if( b_number )
            System.out.printf( " %-5d", i+1 );
        if( b_name )
            System.out.printf( "%-5s", temp_list.get( i ).getName() );
        if( b_phone )
            System.out.printf( "%-10s", temp_list.get( i ).getPhone() );
        if( b_email )
            System.out.printf( "%-5s", temp_list.get( i ).getEmail() );
        if( b_address )
            System.out.printf( "%-7s", temp_list.get( i ).getAddress() );
        if( b_type )
            System.out.printf( "%-10s", temp_list.get( i ).getType() );
        if( b_birthday )
            System.out.printf( "%-1s", temp_list.get( i ).getBirthday() );
        System.out.println( );
    }


    // 儲存通訊錄到記事本
    public void store_contact( )
    {
        PrintWriter storeContact = null;
        try
        {

            storeContact = new PrintWriter( new FileOutputStream(writefile) );
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file contact.txt.");
            System.exit(0);
        }

        storeContact.println( " 姓名         電話號碼                    e-mail             住址        分類          生日" );
        storeContact.println( "——————————————————————————————————————————————————————————————————————————————————————————" );
        for( int i = 0 ; i < myList.size( ) ; i++ ) {
            storeContact.printf( "%-10s", myList.get( i ).getName() );
            storeContact.printf( "%-20s", myList.get( i ).getPhone() );
            storeContact.printf( "%-30s", myList.get( i ).getEmail() );
            storeContact.printf( "%-10s", myList.get( i ).getAddress() );
            storeContact.printf( "%-10s", myList.get( i ).getType() );
            storeContact.printf( "%-1s", myList.get( i ).getBirthday() );
            storeContact.println( );
        }

        storeContact.close( );
    }


    // 控制標題的顯示
    public void display_name( )
    {


        if( b_name ) {
            System.out.printf( "     姓名         " );

        }
        if( b_phone ) {
            System.out.printf( "電話號碼                    " );

        }
        if( b_email ) {
            System.out.printf( "e-mail             " );

        }
        if( b_address ) {
            System.out.printf( "住址        " );

        }
        if( b_type ) {
            System.out.printf( "分類          " );

        }
        if( b_birthday ) {
            System.out.printf( "生日" );

        }
        System.out.println( );

        System.out.println( "———————————————————————————————————————————————————————————————————————————————————————————————————" );
        System.out.println( );
    }


    // 顯示所有標題欄位
    public void display_all_name( )
    {
        System.out.printf( "排序   " );
        System.out.printf( "姓名    " );
        System.out.printf( "電話號碼          " );
        System.out.printf( "e-mail              " );
        System.out.printf( "住址    " );
        System.out.printf( "類別        " );
        System.out.println( "生日" );
        System.out.println( "—————————————————————————————————————————————————————————————————————————————————" );
    }


    // 控制顯示時的欄位
    public void display_elements( int i )
    {
        if( b_number )
            System.out.printf( " %-5d", i+1 );
        if( b_name )
            System.out.printf( "%-10s", myList.get( i ).getName() );
        if( b_phone )
            System.out.printf( "%-20s", myList.get( i ).getPhone() );
        if( b_email )
            System.out.printf( "%-30s", myList.get( i ).getEmail() );
        if( b_address )
            System.out.printf( "%-10s", myList.get( i ).getAddress() );
        if( b_type )
            System.out.printf( "%-10s", myList.get( i ).getType() );
        if( b_birthday )
            System.out.printf( "%-1s", myList.get( i ).birthday );
        System.out.println( );
    }


    // 顯示電話簿所有欄位
    public void display_all_elements( int i )
    {
        System.out.printf( "%-8s", myList.get( i ).getName() );
        System.out.printf( "%-15s", myList.get( i ).getPhone() );
        System.out.printf( "%-22s", myList.get( i ).getEmail() );
        System.out.printf( "%-6s", myList.get( i ).getAddress() );
        System.out.printf( "%-10s", myList.get( i ).getType() );
        System.out.printf( "%-1s", myList.get( i ).getBirthday() );
        System.out.println( );
    }


    // 暫停畫面
    public void print_enter( )
    {
        System.out.print("按Enter鍵回到選單...");
        try
        {
            System.in.read();
        }
        catch(Exception e) {}
    }
}

