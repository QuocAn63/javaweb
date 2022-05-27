/**
 * 
 */

 function MoneyShow({price, discount = null, quantity = 1}) {

    return discount?(Number.parseFloat(price)*(100 - Number.parseInt(discount))/100*quantity).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}):(Number.parseFloat(price)*quantity).toLocaleString('it-IT', {style : 'currency', currency : 'VND'})
}