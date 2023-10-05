function delFruit(fid) {
    if(confirm('you wanna delete?')) {
        window.location.href='del.do?fid=' + fid;
    }
}