import java.util.Scanner;

public class Contact
{
    Scanner sc = new Scanner( System.in );

    public String name;
    public String phone;
    public String email;
    public String address;
    public String type;
    public String birthday;

    public Contact( )
    {

        name = "細菌";
        phone = "0981384864";
        email= "karoro110@yahoo.com.tw";
        address = "桃園";
        type = "朋友";
        birthday = "19971029";
    }

    public Contact( String theName,  String thePhone,
                    String theEmail, String theAddress,  String theType, String theBirthday )
    {

        setName( theName );
        setPhone( thePhone );
        setEmail( theEmail );
        setAddress( theAddress );
        setType( theType );
        setBirthday( theBirthday );
    }

    public Contact( Contact other )
    {
        name = other.getName( );
        phone = other.getPhone( );
        email = other.getEmail( );
        address = other.getAddress( );
        type = other.getType( );
        birthday = other.getBirthday( );
    }

    public boolean setContact( String theName, String thePhone,
                               String theEmail,String theAddress, String theType, String theBirthday )
    {
        if( setName( theName ) &&
                setPhone( thePhone ) && setEmail(theEmail) && setType( theType ) && setBirthday( theBirthday ) )
            return true;
        else
            return false;
    }

    public boolean setName( String theName )
    {
        if( theName != null ) {
            name = theName;
            return true;
        }
        else {
            System.out.println( "姓名格式錯誤！ 請重新輸入：" );
            return false;
        }
    }

    public boolean setPhone( String thePhone )
    {
        if ( thePhone != null && thePhone.charAt(0)==48 && thePhone.charAt(1)==57 && thePhone.length()==10||
             thePhone != null && thePhone.charAt(0)==40 && thePhone.charAt(1)==48 && thePhone.charAt(3)==41 && thePhone.length()==11||
             thePhone != null && thePhone.charAt(0)==40 && thePhone.charAt(1)==48 && thePhone.charAt(3)==41 && thePhone.length()==12||
             thePhone != null && thePhone.charAt(0)==40 && thePhone.charAt(1)==48 && thePhone.charAt(4)==41 && thePhone.length()==11||
             thePhone != null && thePhone.charAt(0)==40 && thePhone.charAt(1)==48 && thePhone.charAt(5)==41 && thePhone.length()==12
        ) {
        phone = thePhone;
        return true;
        }
        else {
            System.out.println( "電話名稱格式錯誤！ 請重新輸入：" );
        return false;
        }

    }

    public boolean setEmail( String theEmail )
    {
        if( theEmail != null && theEmail.indexOf("@")!=-1 && theEmail.indexOf(".com")!=-1 ||
            theEmail != null && theEmail.indexOf("@")!=-1 && theEmail.indexOf(".edu")!=-1    ){
            email = theEmail;
            return true;
        }
        else {
            System.out.println( "Email格式錯誤！ 請重新輸入：" );
            return false;
        }

    }

    public boolean setAddress( String theAddress )
    {
        if( theAddress!= null ) {
            address = theAddress;
            return true;
        }
        else {
            System.out.println( "地區格式錯誤！ 請重新輸入：" );
            return false;
        }

    }

    public boolean setType( String theType )
    {
        if( theType != null ) {
            type = theType;
            return true;
        }
        else {
            System.out.println( "分類錯誤！ 請重新輸入：" );
            return false;
        }

    }

    public boolean setBirthday( String theBirthday )
    {
        if(     theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==49 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==49 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==50 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==51 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==51 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==52 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==52 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<49 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==53 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==53 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==54 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==54 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<49 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==55 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==55 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==56 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==56 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==57 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==48 && theBirthday.charAt(1)==57 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<49 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==48 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==48 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==49 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==49 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<49 && theBirthday.length()==4||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==50 && theBirthday.charAt(2)>47 && theBirthday.charAt(2)<51 && theBirthday.length()==4 ||
                theBirthday!= null && theBirthday.charAt(0)==49 && theBirthday.charAt(1)==50 && theBirthday.charAt(2)==51 && theBirthday.charAt(3)>47 && theBirthday.charAt(3)<50 && theBirthday.length()==4
                )   {
            birthday = theBirthday;
            return true;

        }
        else {
            System.out.println( "生日格式錯誤！ 請重新輸入：" );
            return false;
        }
    }

    public String getName( )
    {
        return name;
    }

    public String getPhone( )
    {
        return phone;
    }

    public String getEmail( )
    {
        return email;
    }

    public String getAddress( )
    {
        return address;
    }

    public String getType( )
    {
        return type;
    }

    public String getBirthday( )
    {
        return birthday;
    }
}

