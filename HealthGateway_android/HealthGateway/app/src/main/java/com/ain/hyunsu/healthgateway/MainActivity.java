package com.ain.hyunsu.healthgateway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ain.hyunsu.healthgateway.resource.D10404MeasurmentResource;
import com.ain.hyunsu.healthgateway.resource.D10404Resource;
import com.ain.ieee11073.devices.Device10404;

import org.eclipse.californium.core.CoapServer;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class MainActivity extends AppCompatActivity {

    private CoapServer myCoapServer;
    private Button startServerBtn, stopServerBtn;
    private TextView ipAddressTxt;
    public static Device10404 D10404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){

        myCoapServer = new CoapServer();
        startServerBtn = (Button) this.findViewById(R.id.startServerBtn);
        stopServerBtn = (Button) this.findViewById(R.id.stopServerBtn);
        ipAddressTxt = (TextView) this.findViewById(R.id.ipAddress);

        setIpAddress(ipAddressTxt);

        startServerBtn.setOnClickListener(onClick);
        stopServerBtn.setOnClickListener(onClick);

        addResource();

    }

    private void addResource(){

        D10404 = new Device10404();

        D10404Resource d10404Resource = new D10404Resource("D10404_DIM", D10404);
        D10404MeasurmentResource d10404MeasurmentResource = new D10404MeasurmentResource("D10404_Measurment", D10404);

        d10404Resource.add(d10404MeasurmentResource);


        myCoapServer.add(d10404Resource);
    }

    private void setIpAddress(TextView ipAddressTxt){
        ipAddressTxt.setText(getIPAddress());
    }

    public static String getIPAddress(){
        try{
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                NetworkInterface intf = en.nextElement();
                for(Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();){
                    InetAddress inetAddress = enumIpAddr.nextElement();

                    if (!inetAddress.isLoopbackAddress()){

                        if(inetAddress instanceof Inet4Address){
                            return inetAddress.getHostAddress().toString();
                        }

                    }
                }
            }
        } catch (SocketException e){
            System.out.println(e);
            return "ERROR Obtaining IP";
        }
        return "No IP Available";
    }


    View.OnClickListener onClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.startServerBtn:
                    myCoapServer.start();

                    break;
                case R.id.stopServerBtn:
                    myCoapServer.stop();
                    break;
                default:
                    break;
            }
        }
    };

}
