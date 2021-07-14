package com.kab.BluetoothTools;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import android.bluetooth.BluetoothAdapter;
@DesignerComponent(
        version = 1,
        description = "",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "")

@SimpleObject(external = true)
@UsesPermissions(permissionNames = "android.permission.BLUETOOTH, android.permission.BLUETOOTH_ADMIN")

public class BluetoothTools extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;
    private BluetoothAdapter mBluetoothAdapter;

    public BluetoothTools(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction()
    public void EnableBluetooth(){
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    mBluetoothAdapter.enable();
    BluetoothEnabled();
   
    }
    @SimpleFunction()
    public void DisableBluetooth(){
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    mBluetoothAdapter.disable();
    BluetoothDisabled();
   }
   @SimpleFunction()
   public void CheckState(){
    if (mBluetoothAdapter.isEnabled()) {
    BluetoothEnabled();
   }
   else{
       BluetoothDisabled();
   }
   if(mBluetoothAdapter == null){
       BluetoothNotSupported();
   } 

   }
   

    @SimpleEvent()
    public void BluetoothEnabled(){
        EventDispatcher.dispatchEvent(this, "BluetoothEnabled");
    }
    @SimpleEvent()
    public void BluetoothDisabled(){
        EventDispatcher.dispatchEvent(this, "BluetoothDisabled");
    }
    @SimpleEvent()
    public void BluetoothNotSupported(){
        EventDispatcher.dispatchEvent(this, "BluetoothNotSupported");
    }
}
