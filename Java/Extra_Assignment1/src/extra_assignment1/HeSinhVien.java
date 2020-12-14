/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra_assignment1;

/**
 *
 * @author May tinh Duy Toi
 */
public class HeSinhVien {
    BACHOC bacHoc;
    THOIGIANDT thoiGianDT;
    SOTC soTC;
}
enum BACHOC{
    DAIHOC, CAODANG
}
enum THOIGIANDT{
    DAIHOC(4), CAODANG(3);
    THOIGIANDT(int value){}
}
enum SOTC{
    DAIHOC(210), CAODANG(150);
    SOTC(int value){}
}