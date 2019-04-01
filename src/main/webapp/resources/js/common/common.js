function changeVerifyCode(img) {
    // Math.random()生成[0,1）的随机数
    // Math.random() * 100 生成[0,100)的随机数
    // Math.floor(number):只取小数点前的整数，比如Math.floor(12.654)得到的就是12
    //Math.floor(Math.random() * 100)得到的就是[0,99]的整数
    //点击切换验证码
    img.src = '../Kaptcha?' + Math.floor(Math.random() * 100);
}