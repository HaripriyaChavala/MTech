#include "vfs.h"
int load_vfs(char* file_name_with_path)
{	

	extern struct file_info f;
	extern struct vfs_info vi;
	extern struct vfs_header_info header;
	extern struct vfs v;
	if(v.vfs_status==VFS_OPEN)
	{
		printf("already loaded");
		return -1;
	}
	FILE* fp=fopen(file_name_with_path,"r+");
	
		fread(&header,sizeof(header),1,fp);
	
	
	v.header=header;
	v.vfs_fp=fp;
	v.vfs_status=VFS_OPEN;
	return 1;
		
}
