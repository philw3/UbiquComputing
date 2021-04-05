public class Data {

    String data;
    String id;

    public void Data(){}

    public Data(String data, String id){
        this.data=data;
        this.id=id;
    }

    public String getData(){
        return this.data;
    }

    public String getId(){
        return this.id;
    }

}
