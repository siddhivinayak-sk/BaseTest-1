select
temp1.cashid as Cashier,
sum(ifnull(temp1.amount,0)-ifnull(temp2.amount,0)) as Amount,
sum(ifnull(temp1.nooftransaction,0)) as noOfTransaction,
sum(ifnull(temp1.voidtransaction,0)) as VoidTransaction,
sum(ifnull(temp1.cancelledtransaction,0)) - ifnull(temp2.cancelledtransaction,0) as CancelledTansaction
from

(
select
paycashierid as cashid,
ifnull(sum(orderamount),0)-ifnull(tmp3.amt,0) as Amount,
ifnull(count(orderno),0)+ifnull(tmp1.count,0) as NoOfTransaction,
ifnull(tmp1.count,0) as VoidTransaction,
tmp2.count as CancelledTransaction
from salesorder so 
left join 
(
select
voiduserid as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count
from salesorder where Date(orderdate)  between ? and ? and status =30 group by voiduserid 
) tmp1 on so.paycashierid=tmp1.id
left join
(
select 
CRTBy as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count
from salesorder 
where Date(orderdate)  between ? and ? and status =7  group by crtby
) tmp2 on so.paycashierid=tmp2.id
left join 
(
select
PayCashierID as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count from salesorder
where Date(orderdate)  between ? and ?  and status =25 group by PayCashierID
) tmp3 on so.paycashierid=tmp3.id
where Date(orderdate)  between ? and ?  and status in (20) and OrderType =1 group by paycashierid

union

select 
CRTBy as cashid,
0 as amount,
0 as nooftransaction,
0 as voidtransaction,
count(orderno) as cncelledtransaction
from 
salesorder 
where Date(orderdate)  between ? and ?  and status =7  and PayCashierID is null and VoidUserId is null group by crtby
) temp1 


left join
(
select
paycashierid as cashid,
ifnull(sum(orderamount),0)-ifnull(tmp3.amt,0) as Amount,
ifnull(count(orderno),0)+ifnull(tmp1.count,0) as NoOfTransaction,
ifnull(tmp1.count,0) as VoidTransaction,
tmp2.count as CancelledTransaction 
from salesorder so 

left join 
(
select
voiduserid as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count 
from salesorder 
where Date(orderdate)  between ? and ? and status =30 group by voiduserid ) tmp1 on so.paycashierid=tmp1.id

left join
(
select
CRTBy as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count
from salesorder where Date(orderdate)  between ? and ? and status =7  group by crtby) tmp2 on so.paycashierid=tmp2.id

left join 
(
select 
PayCashierID as id,
ifnull(sum(orderamount),0) as amt,
count(orderno) as count 
from salesorder where Date(orderdate)  between ? and ?  and status =25 group by PayCashierID ) tmp3 on so.paycashierid=tmp3.id
where Date(orderdate)  between ? and ?  and status in (20) and OrderType =2 group by paycashierid

union
select
CRTBy as cashid,
0 as amount,
0 as nooftransaction,
0 as voidtransaction,
count(orderno) as cncelledtransaction 
from 
salesorder 
where Date(orderdate)  between ? and ?  and status =7  and PayCashierID is null and VoidUserId is null group by crtby
) temp2

on temp1.cashid=temp2.cashid group by temp1.cashid;