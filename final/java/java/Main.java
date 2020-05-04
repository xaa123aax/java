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



    // �n�J�t��
    public void login()
    {
        String account = null, password = null;
        int i=0;
        do {
            i++;
            System.out.print( "�b���G" );
            account = sc.next();
            System.out.print( "�K�X�G" );
            password = sc.next();

            if( account.equals("cis") && password.equals("1234") )
            {
                System.out.println( "�n�J���\�I" );

            }

            else{
                System.out.printf( "�b���αK�X���~�I �Э��s��J�I\n\n" );
                System.out.println( "���~�T���Y�|���}�t��(" + i + "/3)\n" );}
            if( i == 3){
                System.out.println( "�w�����t�ΡI" );
                System.exit( 0 );
            }
        }
        while ( !( account.equals("cis") && password.equals("1234") ) );
    }


    // Ū���H�w
    public void load_contact( )
    {
        Scanner load = null;
        try
        {   System.out.println("�п�J�nŪ�������");
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


    // �D���
    public void welcome( )
    {
        System.out.println("\n�п�J������\�ध�N�X�G");
        System.out.println("1.�޲z�\��@�@�@�@�@�@2.�ϥΪ̥\��@�@�@�@�@3.����");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                control( );
            else if (  temp.equalsIgnoreCase("2") )
                user( );
            else if(  temp.equalsIgnoreCase("3") ) {
                store_contact( );
                System.out.println( "�w�����t�ΡI" );
                System.exit( 0 );
            }
            else {
                System.out.println("��J���~�I �Э��s��J������\�ध�N�X�G");
                temp = sc.next();
            }
        }
    }


    // �޲z�\����
    public void control( )
    {
        System.out.println("\n�п�J������\�ध�N�X�G");
        System.out.println("1.�]�w�i��ܪ����@�@2.�W�@��");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                set_display( );
            else if(  temp.equalsIgnoreCase("2") )
                welcome( );
            else {
                System.out.println("\n��J���~�I �Э��s��J������\�ध�N�X�G");
                System.out.println("1.�]�w�i��ܪ����@�@2.�W�@��");
                temp = sc.next();
            }
        }
    }


    // �]�w�������n���
    public void set_display( )
    {
        System.out.println("\n�п�ܦU���O�_�n���(��JY/N)�G");


        System.out.print("�ƧǡG");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("�m�W�G");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("�q�ܸ��X�G");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("e-mail�G");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("�����G");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("�ͤ�G");
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
                System.out.print("��J���~�I �Э��s��J�G");
                temp = sc.next( );
            }

        System.out.print("\n�]�w���\�I�@");
        print_enter( );
        control( );
    }


    // �ϥΪ̥\����
    public void user( )
    {
        System.out.println("\n�п�J������\�ध�N�X�G");
        System.out.println("1.�s�W�@�@�@�@�@�@�@�@2.�d�ߡ@�@�@�@�@�@�@�@3.�ק�");
        System.out.println("4.�R���@�@�@�@�@�@�@�@5.��ܡ@�@�@�@�@�@�@�@6.�O�s/�л\");
        System.out.println("0.�W�@��");

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

                System.out.print( "\n�x�s���\�I�@" );
                print_enter( );
                welcome( );
            }
            else if(  temp.equalsIgnoreCase("0") )
                welcome( );
            else {
                System.out.println("\n��J���~�I �Э��s��J������\�ध�N�X�G");
                System.out.println("1.�s�W�@�@�@�@�@�@�@�@2.�d�ߡ@�@�@�@�@�@�@�@3.�ק�");
                System.out.println("4.�R���@�@�@�@�@�@�@�@5.��ܡ@�@�@�@�@�@�@�@6.�O�s/�л\");
                System.out.println("0.�W�@��");
                temp = sc.next();
            }
        }
    }
    //�O�s/�л\
    public void writefile_contact( ){

        System.out.println( "�п�J�n�g�J���ɮצW�١A�Y���ƫh�мg" );
        writefile=sc.next()+".txt";

    }

    // �s�W����
    public void add_contact( )
    {
        person = new Contact( );

        System.out.println("\n�п�J���s�W���m�W�G");
        temp = sc.next( );
        while( !person.setName( temp ) )
            temp = sc.next( );

        System.out.println("\n�п�J���H���q�ܸ��X�G");
        temp = sc.next( );
        while( !person.setPhone( temp ) )
            temp = sc.next( );

        System.out.println("\n�п�J���H��e-mail�G");
        temp = sc.next( );
        while( !person.setEmail( temp ) )
            temp = sc.next( );

        System.out.println("\n�п�J���H����}�G");
        temp = sc.next( );
        while( !person.setAddress( temp ) )
            temp = sc.next( );

        System.out.println("\n�п�ܦ��H�����G");
        System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
        System.out.println("4.���͡@�@�@�@�@�@�@5.��L");
        boolean b = true;
        temp = sc.next( );
        while( b )
            switch( temp ) {
                case "1":
                    person.setType( "�P��" ); b = false; break;
                case "2":
                    person.setType( "�B��" ); b = false; break;
                case "3":
                    person.setType( "�a�H" );  b = false; break;
                case "4":
                    person.setType( "����" );   b = false; break;
                case "5":
                    person.setType( "��L" ); b = false; break;
                default:
                    System.out.println("��J���~�I�Э��s��ܱ��s�W���s���H�����G");
                    System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
                    System.out.println("4.���͡@�@�@�@�@�@�@5.��L");
                    temp = sc.next( );
            }

        System.out.println("\n�п�J���s�W���ͤ�G");
        temp = sc.next( );
        while( !person.setBirthday( temp ) )
            temp = sc.next( );

        myList.add( person );

        display_all_name( );
        System.out.printf( " %-5d", myList.size( ) );
        display_all_elements( myList.size( ) - 1 );
        System.out.print("\n�s�W���\!�@");
        print_enter( );
        user( );
    }


    // �d�H
    public void search_contact( )
    {
        int x = 0;

        System.out.println("\n�п�J���d�ߪ��m�W������G");
        System.out.println("1.�m�W�@�@�@�@�@�@�@�@2.�q�ܸ��X�@�@�@�@�@�@3.�W�@��");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                x = 0;
                System.out.println("\n�п�J���d�m�W���m�W�G");
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
                    System.out.println( "�L���H�I" );

                System.out.println( );
                print_enter( );

                user( );
            }

            else if(  temp.equalsIgnoreCase("2") ) {
                x = 0;
                System.out.println("\n�п�J���H���q�ܸ��X�G");
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
                    System.out.println( "�L���q�ܸ��X�I" );

                System.out.println( );
                print_enter( );

                user( );
            }

            else if (  temp.equalsIgnoreCase("3") )
                user( );

            else {
                System.out.println("\n��J���~�I �Э��s��J���d�ߪ��s���H���G");
                System.out.println("1.�m�W�@�@�@�@�@�@�@�@2.�q�ܸ��X�@�@�@�@�@�@3.�W�@��");
                temp = sc.next();
            }
        }
    }


    // �ק������
    public void edit_contact( )
    {
        System.out.println("\n�п�J���ק諸�H���ƧǸ�(��J0�h�^��W�@��)�G");

        int number = sc.nextInt( );
        while( number > 0 ) {
            if( number > myList.size( ) ) {
                System.out.println("�L���ƧǡI�Э��s��J���ק諸�s���H�Ƨ�(��J0�h�^��W�@��)�G");
                number = sc.nextInt( );
                continue;
            }
            number--;

            System.out.println( "���ק諸�H��ơG" );
            display_all_elements( number );

            System.out.println("\n�п�ܱ��ק諸�s���H���G");
            System.out.println("1.�m�W�@�@�@�@�@�@�@�@2.�q�ܸ��X�@�@�@�@�@�@�@�@3.e-mail");
            System.out.println("4.��}�@�@�@�@�@�@�@�@5.���O                 6.�ͤ�");
            temp = sc.next();
            while( true ) {
                if(  temp.equalsIgnoreCase("1") ) {
                    System.out.println("\n�п�J�s���m�W�G");
                    temp = sc.next( );
                    while( !myList.get( number ).setName( temp ) )
                        temp = sc.next( );
                }


                else if(  temp.equalsIgnoreCase("2") ) {
                    System.out.println("\n�п�J���H���q�ܸ��X�G");
                    temp = sc.next( );
                    while( !myList.get( number ).setPhone( temp ) )
                        temp = sc.next( );
                }
                else if(  temp.equalsIgnoreCase("3") ) {
                    System.out.println("\n�п�J���H��e-mail�G");
                    temp = sc.next( );
                    while( !myList.get( number ).setEmail( temp ) )
                        temp = sc.next( );
                }

                else if(  temp.equalsIgnoreCase("4") ) {
                    System.out.println("\n�п�J���H��}�G");
                    temp = sc.next( );
                    while( !myList.get( number ).setAddress( temp ) )
                        temp = sc.next( );
                }
                else if(  temp.equalsIgnoreCase("5") ) {
                    System.out.println("\n�п�ܷs���s���H�����G");
                    System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
                    System.out.println("4.���͡@�@�@�@�@�@�@5.��L");
                    boolean b = true;
                    temp = sc.next( );
                    while( b )
                        switch( temp ) {
                            case "1":
                                myList.get( number ).setType( "�P��" );   b = false; break;
                            case "2":
                                myList.get( number ).setType( "�B��" );   b = false; break;
                            case "3":
                                myList.get( number ).setType( "�a�H" );    b = false; break;
                            case "4":
                                myList.get( number ).setType( "����" ); b = false; break;
                            case "5":
                                myList.get( number ).setType( "��L" );   b = false; break;
                            default:
                                System.out.println("��J�榡���~�I�Э��s��ܷs�����H�����G");
                                System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
                                System.out.println("4.���͡@�@�@�@�@�@�@5.��L");
                                temp = sc.next( );
                        }
                }

                else if(  temp.equalsIgnoreCase("6") ) {
                    System.out.println("\n�п�J���H�ͤ�G");
                    temp = sc.next( );
                    while( !myList.get( number ).setBirthday( temp ) )
                        temp = sc.next( );
                }

                else {
                    System.out.println("\n��J���~�I �Э��s��ܱ��ק諸�s���H���G");
                    System.out.println("1.�m�W�@�@�@�@�@�@�@�@2.�q�ܸ��X�@�@�@�@�@�@�@�@3.e-mail");
                    System.out.println("4.��}�@�@�@�@�@�@�@�@5.����                 6.�ͤ�");
                    temp = sc.next();
                }

                display_all_name( );
                System.out.printf( " %-5d", number );
                display_all_elements( number );
                System.out.print("\n�ק令�\�I�@");
                print_enter( );
                break;
            }
            user( );
        }

        user( );
    }


    // �R���H��
    public void delete_contact( )
    {
        System.out.println("\n�п�J���R�����H���ƧǸ�(��J0�h�^��W�@��)�G");

        int number = sc.nextInt( );
        while( number > 0 ) {
            if( number > myList.size( ) ) {
                System.out.println("�L���ƧǡI�Э��s��J���R�����H���ƧǸ�(��J0�h�^��W�@��)�G");
                number = sc.nextInt( );
                continue;
            }

            display_all_name( );
            System.out.printf( " %-5d", --number );
            display_all_elements( number );
            myList.remove( number );

            System.out.print("\n�R�����\�I�@");
            print_enter( );
            break;
        }

        user( );
    }


    // ���
    public void display( )
    {
        System.out.println("\n�п����ܤ覡�G");
        System.out.println("1.�Ҧ������@�@�@�@�@�@2.��@�����@�@�@�@�@�@0.�W�@��");

        temp = sc.next();
        while( true ) {
            if(  temp.equalsIgnoreCase("1") )
                display_all( );
            else if(  temp.equalsIgnoreCase("2") )
                display_type( );
            else if(  temp.equalsIgnoreCase("0") )
                user( );
            else {
                System.out.println("\n��J�榡���~�I �Э��s�����ܤ覡�G");
                System.out.println("1.�Ҧ������@�@�@�@�@�@2.��@�����@�@�@�@�@�@0.�W�@��");

                temp = sc.next();
            }
        }
    }


    // ��ܩҦ�����
    public void display_all( )
    {
        System.out.println("\n�п����ܤ覡�G");
        System.out.println("1.��ܩҦ���ơ@�@�@�@2.������ܡ@�@�@�@�@�@3.��ܩҦ����(�̥ͤ�Ƨ�)");
        System.out.println("0.�W�@��");

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
                System.out.println("\n��J�榡���~�I �Э��s�����ܤ覡�G");
                System.out.println("1.��ܩҦ���ơ@�@�@�@2.������ܡ@�@�@�@�@�@0.�W�@��");
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
    // �Ҧ������������
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
        System.out.println("1.�W�@���@�@�@�@�@�@�@2.�U�@���@�@�@�@3.�ۦ��J���X");
        System.out.println("0.�^��ϥΪ̥\����");

        temp = sc.next( );
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                if( page == 1 )
                    System.out.println("\n�����Ĥ@���I�@�Э��s��ܡG");

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
                    System.out.println("\n�����̫�@���I�@�Э��s��ܡG");

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
                System.out.println( "\n�п�J���s�������X�G" );
                page = sc.nextInt( );
                while( ( myList.size( ) - 1 ) - ( page - 1 ) * 10 < 0 ) {
                    System.out.println( "�L�����X�I �Э��s��J���s�������X�G" );
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


            System.out.println("1.�W�@���@�@�@�@�@�@�@2.�U�@���@�@�@�@3.�ۦ��J���X");
            System.out.println("0.�^��ϥΪ̥\����");
            temp = sc.next( );
        }
    }

    // ��@�������
    public void display_type( )
    {
        int i;
        String type;
        boolean b = true;

        System.out.println("\n�п�ܱ���ܪ��s���H�����G");
        System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
        System.out.println("4.���͡@�@�@�@�@�@�@5.��L");

        type = sc.next( );
        while( b )
            switch( type ) {
                case "1":
                    type = "�P��";    b = false; break;
                case "2":
                    type = "�B��";    b = false; break;
                case "3":
                    type = "�a�H"; b = false; break;
                case "4":
                    type = "����";  b = false; break;
                case "5":
                    type = "��L";       b = false; break;
                default:
                    System.out.println("��J���~�I�Э��s��ܷs���s���H�����G");
                    System.out.println("1.�P�ǡ@�@�@�@�@�@�@2.�B�͡@�@�@�@�@�@�@3.�a�H");
                    System.out.println("4.���͡@�@�@�@�@�@�@5.��L");
                    type = sc.next( );
            }

        temp_list.clear( );
        for( i = 0 ; i < myList.size( ) ; i++ ) {
            if( type.equalsIgnoreCase( myList.get( i ).getType( ) ) )
                temp_list.add( myList.get( i ) );
        }
        if( temp_list.size( ) == 0 ) {
            System.out.println( "\n�L���������m�W�I" );
            System.out.println( );
            print_enter( );
            display_type( );
        }

        System.out.println("\n�п����ܤ覡�G");
        System.out.println("1.��ܩҦ���������ơ@2.������ܡ@�@�@�@�@�@3.�W�@��");

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
                System.out.println("\n��J���~�I �Э��s�����ܤ覡�G");
                System.out.println("1.��ܩҦ���������ơ@2.������ܡ@�@�@�@�@�@3.�W�@��");
                temp = sc.next();
            }
        }
    }


    // ��@�����������
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
        System.out.println("1.�W�@���@�@�@�@�@�@�@2.�U�@���@�@�@�@3.�ۦ��J���X");
        System.out.println("4.�^��ϥΪ̥\����");

        temp = sc.next( );
        while( true ) {
            if(  temp.equalsIgnoreCase("1") ) {
                if( page == 1 )
                    System.out.println("\n�����Ĥ@���I�@�Э��s��ܡG");

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
                    System.out.println("\n�����̫�@���I�@�Э��s��ܡG");

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
                System.out.println( "\n�п�J���s�������X�G" );
                page = sc.nextInt( );
                while( ( temp_list.size( ) - 1 ) - ( page - 1 ) * 10 < 0 ) {
                    System.out.println( "�L�����X�I �Э��s��J���s�������X�G" );
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


            System.out.println("1.�W�@���@�@�@�@�@�@�@2.�U�@���@�@�@�@3.�ۦ��J���X");
            System.out.println("4.�^��ϥΪ̥\����");
            temp = sc.next( );
        }
    }


    // ������ܮɪ����for�S�w�����������
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


    // �x�s�q�T����O�ƥ�
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

        storeContact.println( " �m�W         �q�ܸ��X                    e-mail             ��}        ����          �ͤ�" );
        storeContact.println( "�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X" );
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


    // ������D�����
    public void display_name( )
    {


        if( b_name ) {
            System.out.printf( "     �m�W         " );

        }
        if( b_phone ) {
            System.out.printf( "�q�ܸ��X                    " );

        }
        if( b_email ) {
            System.out.printf( "e-mail             " );

        }
        if( b_address ) {
            System.out.printf( "��}        " );

        }
        if( b_type ) {
            System.out.printf( "����          " );

        }
        if( b_birthday ) {
            System.out.printf( "�ͤ�" );

        }
        System.out.println( );

        System.out.println( "�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X" );
        System.out.println( );
    }


    // ��ܩҦ����D���
    public void display_all_name( )
    {
        System.out.printf( "�Ƨ�   " );
        System.out.printf( "�m�W    " );
        System.out.printf( "�q�ܸ��X          " );
        System.out.printf( "e-mail              " );
        System.out.printf( "��}    " );
        System.out.printf( "���O        " );
        System.out.println( "�ͤ�" );
        System.out.println( "�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X�X" );
    }


    // ������ܮɪ����
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


    // ��ܹq��ï�Ҧ����
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


    // �Ȱ��e��
    public void print_enter( )
    {
        System.out.print("��Enter��^����...");
        try
        {
            System.in.read();
        }
        catch(Exception e) {}
    }
}

