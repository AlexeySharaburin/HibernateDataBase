select *
from order od
         join customer cu on od.customer_id = cu.id
where name = ?;
