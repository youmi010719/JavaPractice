package com.override;

 class textSalary extends Income {
  public textSalary(double income){
   super(income);
  }
  @Override
  public  double getTax() {
   if(income <= 4000)
    return 0;
   else
     return (income-4000)*0.2;
  }

}
