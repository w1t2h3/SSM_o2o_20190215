function changeVerifyCode(img) {
    // Math.random()生成（0,1）的随机数
    // Math.random() * 100 生成[0,99]的随机数，也就是生成最多两位的整数数字
    // Math.floor(number):只取小数点前的整数，比如Math.floor(12.654)得到的就是12
    //点击切换验证码
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}