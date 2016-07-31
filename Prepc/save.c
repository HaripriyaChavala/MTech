#include "vfs.h"
int save(char * saved_name,char * path_to_file)
{
	extern struct file_info f;
	extern struct vfs_info vi;
	extern struct vfs_header_info header;
	extern struct vfs v;
	if(v.vfs_status!=VFS_OPEN)
	{
		printf("VFS is not loaded");
		return -1;
	}
	FILE*fp;
	fp=fopen(path_to_file,"r+");
	fseek(v.vfs_fp,0,SEEK_END);
	int offset=ftell(v.vfs_fp); 
	fseek(fp,0,SEEK_END);
	int size=ftell(fp);
	fseek(fp,0,SEEK_SET);
	char *ptr;
	ptr=(char*)malloc(sizeof(char)*offset);
	fread(ptr,size,1,fp);
	fwrite(ptr,size,1,v.vfs_fp);
	close(fp);
	vi.num_files=vi.num_files+1;
	strcpy(f.fname,saved_name);
	f.offset=offset;
	f.filesize=size;
	vi.size=vi.size+size;
	header.v=vi;
	header.files[vi.num_files-1]=f;
	return 1;
	

}
