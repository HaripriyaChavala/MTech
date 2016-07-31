#include "vfs.h"
int create_vfs(char * vfs_name)
{

	extern struct file_info f;
	extern struct vfs_info vi;
	extern struct vfs_header_info header;
	extern struct vfs v;
	FILE*fp;
	int i;
	fp=fopen(vfs_name,"w");
	strcpy(vi.vfs_name,vfs_name);
	vi.num_files=0;
	vi.size=sizeof(header);
	header.v=vi;
	for(i=0;i<MAX_FILES;i++)
	{
		strcpy(f.fname,"");
		f.offset=0;
		f.filesize=0;
		header.files[i]=f;		
	}
	fwrite(&header,sizeof(header),1,fp);
	fclose(fp);
	v.vfs_status=VFS_CLOSED;
	return 1;

}
