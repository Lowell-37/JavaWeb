function delFruit(fid) {
    if(confirm('you wanna delete?')) {
        window.location.href='del.do?fid=' + fid;
    }
}

function page(pageNO) {
    window.location.href="index?pageNO="+pageNO;
}