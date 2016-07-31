#include "vfs.h"
int extract(char * file)
{
	extern struct file_info f;
	extern struct vfs_info vi;
	extern struct vfs_header_info header;
	extern struct vfs v;
	int offset;
	int size;
	FILE* fp;
	int i;
	
	if(v.vfs_status==VFS_OPEN)
	{
		printf("VFS is not loaded");
		return -1;
	}
	int flag=0;
	for(i=0;i<vi.num_files;i++)
	{
		
		if(strcmp(header.files[i].fname,file)==0)
		{
			offset=header.files[i].offset;
			size=header.files[i].filesize;
			flag=1;
			
		}
	}
	if(!flag)
	{
		printf("no such file present in VFS");
		return -1;
	}
	fp=fopen("newfile.c","w");
	fseek(v.vfs_fp,offset,SEEK_SET);
	char * ptr;
	
	ptr=(char *)malloc(sizeof(char)*size);
	fread(ptr,size,1,v.vfs_fp);
	fwrite(ptr,size,1,fp);

	return 1;
}
