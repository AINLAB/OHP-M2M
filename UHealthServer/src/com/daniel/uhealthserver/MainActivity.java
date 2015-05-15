package com.daniel.uhealthserver;

import org.eclipse.californium.core.CoapServer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daniel.uhealthserver.coapresources.DIMXMLResource;
import com.daniel.uhealthserver.coapresources.ObservableResource;
import com.daniel.uhealthserver.utils.Utils;

public class MainActivity extends Activity {

			private CoapServer myCoapServer;
			private Button startServerBtn, stopServerBtn;
			private TextView ipAddressTxT;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				init();
			}

			private void init() {
				myCoapServer = new CoapServer();
				startServerBtn = (Button) this.findViewById(R.id.startServerBtn);
				stopServerBtn = (Button) this.findViewById(R.id.stopServerBtn);
				ipAddressTxT = (TextView) this.findViewById(R.id.ipAddress);
				setIpAddress(ipAddressTxT);
				startServerBtn.setOnClickListener(onClick);
				stopServerBtn.setOnClickListener(onClick);
				addResources(myCoapServer);
		
			}
		
			private void addResources(CoapServer coapServer)
			{
				coapServer.add(new ObservableResource("AndroidCoap")); // Add the observable resource ro the COAP server. 
				DIMXMLResource bloodPreDIMRes = new DIMXMLResource(MainActivity.this,
						"bloodPressure", "mds-attributes/blood-pressure.xml");
				DIMXMLResource spo2DIMRes = new DIMXMLResource(MainActivity.this,
						"Spo2", "mds-attributes/pulse-oximeter-NONIN.xml");
				DIMXMLResource bodyCompDIMRes = new DIMXMLResource(MainActivity.this,
						"BodyCompositionMonitor", "mds-attributes/body-composition-monitor.xml");
				DIMXMLResource cardioVascularDIMRes = new DIMXMLResource(MainActivity.this,
						"cardiovascularmonitor", "mds-attributes/cardio-vascular.xml");
				DIMXMLResource medicalMonitorDIMRes = new DIMXMLResource(MainActivity.this,
						"medicationmonitor", "mds-attributes/medication-monitor.xml");
				DIMXMLResource strengthfitnessEquiDIMRes= new DIMXMLResource(MainActivity.this,
						"strenghtfitnessmonitor", "mds-attributes/strength-fitness-equipment.xml");
				
				coapServer.add(bloodPreDIMRes);
				coapServer.add(spo2DIMRes);
				coapServer.add(bodyCompDIMRes);
				coapServer.add(cardioVascularDIMRes);
				coapServer.add(medicalMonitorDIMRes);
				coapServer.add(strengthfitnessEquiDIMRes);
			}
		
			View.OnClickListener onClick = new View.OnClickListener() {
		
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					switch (v.getId()) {
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
		
			private void setIpAddress(TextView ipAddressTxT) {
		
				ipAddressTxT.setText(Utils.getIPAddress(true));
			}

	

	
}
