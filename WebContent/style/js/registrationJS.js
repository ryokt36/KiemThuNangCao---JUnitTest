/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validate() {
    var mk = document.form.txt_Pass1.value;
    var nlmk = document.form.txt_rePass1.value;

    var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;


    if (document.form.txt_Username1.value == "") {
        alert("Tên tài khoản không được để trống");
        document.form.txt_Username1.focus();
        return false;
    }
    if (document.form.txt_Pass1.value == "" || document.form.txt_Pass1.value.length < 5) {
        alert("Mật khẩu không được để trống và phải trên 5 ký tự ");
        document.form.txt_Pass1.focus();
        return false;
    }
    if (document.form.txt_rePass1.value == "") {
        alert("Xác nhận mật khẩu không được để trống");
        document.form.txt_rePass1.focus();
        return false;
    }
    if (mk != nlmk) {
        alert("Xác nhận mật khẩu sai!");
        document.form.txt_rePass1.focus();
        return false;
    }
    if (document.form.txt_email1.value == "") {
        alert("Mail không được để trống");
        document.form.txt_email1.focus();
        return false;
    }
    if (!re.test(document.form.txt_email1.value)) {
        alert("Mail sai định dạng");
        document.form.txt_email1.focus();
        return false;
    }
    if (document.form.txt_sdt1.value == "" || document.form.txt_sdt1.value.length < 10) {
        alert("SĐT không được để trống");
        document.form.txt_sdt1.focus();
        return false;
    }
    if (document.form.txt_sdt1.value.length < 10) {
        alert("SĐT phải từ 10 số trở lên");
        document.form.txt_sdt1.focus();
        return false;
    }



    return true;

}

      