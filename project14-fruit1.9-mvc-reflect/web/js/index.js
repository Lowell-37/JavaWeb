function delFruit(fid){
    if(confirm('you wanna delete?')){
        window.location.href='fruit.do?fid='+fid+'&operate=del';
    }
}

function page(pageNo){
    window.location.href="fruit.do?pageNo="+pageNo;
}