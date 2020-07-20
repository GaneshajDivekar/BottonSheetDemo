package com.app.bubbledemoapp.Utils

import android.content.Context
import android.content.SharedPreferences


class SessionManger
constructor(context: Context, prefFileName: String) {

    private val mPrefs: SharedPreferences
    private var editor: SharedPreferences.Editor? = null

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        editor = mPrefs.edit()
    }


    fun getCurrentUserLoggedInMode(): Boolean {
        return mPrefs.getBoolean(PREF_KEY_USER_LOGGED_IN_MODE, false)
    }

    fun setCurrentUserLoggedInMode(mode: Boolean) {
        mPrefs.edit().putBoolean(PREF_KEY_USER_LOGGED_IN_MODE, mode).apply()
    }

    fun setSaleInvoiceCount(saleInvoiceCountt: String) {
        mPrefs.edit().putString(SALES_INVOICE_COUNT, saleInvoiceCountt).apply()

    }

    fun getSaleInvoiceCount(): String {
        return mPrefs.getString(SALES_INVOICE_COUNT, "")!!
    }


    fun setCurrentPlantId(plant_id: String) {
        mPrefs.edit().putString(PLANT_ID, plant_id).apply()

    }

    fun getCurrentPlantId(): String {
        return mPrefs.getString(PLANT_ID, "")!!
    }

    fun setCurrentPlantName(plant_name: String) {
        mPrefs.edit().putString(PLANT_NAME, plant_name).apply()

    }

    fun getCurrentPlantName(): String {
        return mPrefs.getString(PLANT_NAME, "")!!
    }


    fun setSalesRmName(sales_rm_name: String) {
        mPrefs.edit().putString(SELECTED_SALES_RM_NAME, sales_rm_name).apply()

    }

    fun getsetSalesRmName(): String {
        return mPrefs.getString(SELECTED_SALES_RM_NAME, "")!!
    }


    fun setUserID(user_id: String) {
        mPrefs.edit().putString(USER_ID, user_id).apply()

    }

    fun getUserID(): String {
        return mPrefs.getString(USER_ID, "")!!
    }


    fun setUserName(user_name: String) {
        mPrefs.edit().putString(USER_NAME, user_name).apply()

    }

    fun getUserName(): String {
        return mPrefs.getString(USER_NAME, "")!!
    }


    fun setSalesRmID(sales_rm_id: String) {
        mPrefs.edit().putString(SELECTED_SALES_RM_ID, sales_rm_id).apply()

    }

    fun getsetSalesRmID(): String {
        return mPrefs.getString(SELECTED_SALES_RM_ID, "")!!
    }


    fun setNoOfSessions(no_of_sessions: String) {
        mPrefs.edit().putString(USER_SESSION_NUMBER, no_of_sessions).apply()

    }

    fun getNoOfSessions(): String {
        return mPrefs.getString(USER_SESSION_NUMBER, "")!!
    }


    fun setCounterId(counter_id: String) {
        mPrefs.edit().putString(COUNTER_ID, counter_id).apply()

    }

    fun getCounterId(): String {
        return mPrefs.getString(COUNTER_ID, "")!!
    }


    fun setCounterName(counter_id: String) {
        mPrefs.edit().putString(COUNTER_NAME, counter_id).apply()

    }

    fun getCounterName(): String {
        return mPrefs.getString(COUNTER_NAME, "")!!
    }


    fun setSaleInvoiceNumber(invoice_number: String) {
        mPrefs.edit().putString(SALE_INVOICE_NUMBER, invoice_number).apply()
    }

    fun getSaleInvoiceNumber(): String {
        return mPrefs.getString(SALE_INVOICE_NUMBER, "")!!
    }


    fun setCustomerName(customer_name: String) {
        mPrefs.edit().putString(CUSTOMER_NAME, customer_name).apply()
    }

    fun getCustomerName(): String {
        return mPrefs.getString(CUSTOMER_NAME, "")!!
    }


    fun setCustomerUniqueId(customer_unique_id: String) {
        mPrefs.edit().putString(CUSTOMER_UNIQUE_ID, customer_unique_id).apply()

    }

    fun getCustomerUniqueId(): String {
        return mPrefs.getString(CUSTOMER_UNIQUE_ID, "")!!
    }


    fun setCustomerId(customer_id: String) {
        mPrefs.edit().putString(CUSTOMER_ID, customer_id).apply()
    }

    fun getCustomerId(): String {
        return mPrefs.getString(CUSTOMER_ID, "")!!
    }


    fun setCustomerLoyaltyPoint(customer_loyalty_point: String) {
        mPrefs.edit().putString(CUSTOMER_LOYALTY_POINT, customer_loyalty_point).apply()
    }

    fun getCustomerLoyaltyPoint(): String {
        return mPrefs.getString(CUSTOMER_LOYALTY_POINT, "")!!
    }


    fun setCustomerRedeemPoint(customer_redeem_point: String) {
        mPrefs.edit().putString(CUSTOMER_REDEEM_POINT, customer_redeem_point).apply()
    }

    fun getCustomerRedeemPoint(): String {
        return mPrefs.getString(CUSTOMER_REDEEM_POINT, "")!!
    }


    fun setTotalValue(total_amount: String) {
        mPrefs.edit().putString(TOTAL_CART_VALUE, total_amount).apply()
    }

    fun getTotalValue(): String {
        return mPrefs.getString(TOTAL_CART_VALUE, "")!!
    }


    fun setLoyaltyPointConversion(loyalty_point_conversion: String) {
        mPrefs.edit().putString(CUSTOMER_LOYALTY_POINT_CONVERSION, loyalty_point_conversion).apply()
    }

    fun getLoyaltyPointConversion(): String {
        return mPrefs.getString(CUSTOMER_LOYALTY_POINT_CONVERSION, "")!!
    }


    fun clearSessionManger() {
        editor!!.clear()
        editor!!.commit()

    }


    fun getPrintData(): String? {
        return mPrefs.getString(PRINT_DATA, "")
    }

    fun setPrintData(print_data: String) {
        mPrefs.edit().putString(PRINT_DATA, print_data).apply()
    }



    fun getPlantCinNo(): String? {
        return mPrefs.getString(PLANT_CIN_NO, "")
    }

    fun setPlantCinNo(cin_no: String) {
        mPrefs.edit().putString(PLANT_CIN_NO, cin_no).apply()
    }



    fun getCompanyDisplayName(): String? {
        return mPrefs.getString(COMAPNY_DISPLAY_NAME, "")
    }

    fun setCompanyDisplayName(comapy_display_name: String) {
        mPrefs.edit().putString(COMAPNY_DISPLAY_NAME, comapy_display_name).apply()
    }





    fun getStateName(): String? {
        return mPrefs.getString(STATE_NAME, "")
    }

    fun setStateName(state_name: String) {
        mPrefs.edit().putString(STATE_NAME, state_name).apply()

    }




    fun getStateUTCode(): String? {
        return mPrefs.getString(STATE_UT_CODE, "")
    }

    fun setStateUTCode(state_ut_code: String) {
        mPrefs.edit().putString(STATE_UT_CODE, state_ut_code).apply()

    }




    fun getRegisterTelephony(): String? {
        return mPrefs.getString(REGISTER_TELEPHONE, "")
    }

    fun setRegisterTelephony(register_telephony: String) {
        mPrefs.edit().putString(REGISTER_TELEPHONE, register_telephony).apply()

    }



    fun getPlantGstin(): String? {
        return mPrefs.getString(PLANT_GSTIN, "")
    }

    fun setPlantGstin(plant_gstin: String) {
        mPrefs.edit().putString(PLANT_GSTIN, plant_gstin).apply()

    }

    fun getPlantAddress(): String? {
        return mPrefs.getString(PLANT_ADDRESS, "")
    }

    fun setPlantAddress(plant_address: String) {
        mPrefs.edit().putString(PLANT_ADDRESS, plant_address).apply()

    }

    companion object {

        const val PREF_FILE_NAME = "Kheliya.pref"
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val SALES_INVOICE_COUNT = "sales_invoice_count"
        private val PLANT_ID = "current_login_plant_id"
        private val PLANT_NAME = "current_login_plant_name"
        private val SELECTED_SALES_RM_NAME = "sales_rm_name"
        private val SELECTED_SALES_RM_ID = "sales_rm_id"
        private val USER_SESSION_NUMBER = "no_of_session"
        private val COUNTER_ID = "counter_id"
        private val USER_ID = "user_id"
        private val USER_NAME = "user_name"
        private val COUNTER_NAME = "counter_name"
        private val CUSTOMER_UNIQUE_ID = "customer_unique_id"
        private val SALE_INVOICE_NUMBER = "sale_invoice_number"
        private val CUSTOMER_NAME = "customer_name"
        private val CUSTOMER_ID = "customer_id"
        private val CUSTOMER_LOYALTY_POINT = "customer_loyalty_points"
        private val CUSTOMER_REDEEM_POINT = "redeem_points"
        private val CUSTOMER_LOYALTY_POINT_CONVERSION = "loyalty_point_conversion"
        private val TOTAL_CART_VALUE = "total_cart_value"
        private  val PRINT_DATA = "print_data"
        private  val PLANT_CIN_NO = "plant_cin_no"
        private  val COMAPNY_DISPLAY_NAME = "company_display_name"
        private  val STATE_NAME ="state_name"
        private val STATE_UT_CODE = "state_ut_code"
        private val REGISTER_TELEPHONE = "register_telephone"
        private val PLANT_GSTIN = "plant_gstin"
        private val PLANT_ADDRESS = "plant_address"



            /*    sessionManager?.setPrintData(
        plantDaoTemp?.plant_cin_no +
        "\t\t" + plantDaoTemp?.company_display_name +
        "\t\t" + plantDaoTemp?.state_name +
        "\t\t" + plantDaoTemp?.state_ut_code +
        "\t\t" + plantDaoTemp?.register_telephone +
        "\t\t" + plantDaoTemp?.plant_gstin +
        "\t\t" + plantDaoTemp?.plant_address
        )*/
    }
}


