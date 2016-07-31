#include<stdio.h>
#include<string.h>
#include<stdlib.h>


main()
{
int s;
s=create_vfs("vfs_test.txt");
printf("create status = %d\n",s);
s=load_vfs("vfs_test.txt");
printf("load status = %d\n",s);
s=save("vfs_new.c","vfs.h");
printf("save status = %d\n",s);
s=unload_vfs();
printf("unload status = %d\n",s);
s=extract("vfs_new.c");
printf("extract status=%d\n",s);

}






















