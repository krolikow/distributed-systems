#ifndef DEMO
#define DEMO

module Demo
{
  exception NoInput {};

  interface FreqIdemp
  {
    int add(int a, int b);
  };

  interface FreqNotIdemp
  {
   int getFibb();
  };

  interface RarIdemp
  {
    int getData(int i);
  };

  interface RarNotIdemp
  {
     void processData(string dataSeq);
  };
};

#endif
