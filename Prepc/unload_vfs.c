
#include "vfs.h"
int unload_vfs()
{
extern struct file_info f;
	extern struct vfs_info vi;
	extern struct vfs_header_info header;
	extern struct vfs v;
if(v.vfs_status!=VFS_OPEN)
{
printf("VFS not loaded");
return -1;
}
fseek(v.vfs_fp,0,SEEK_SET);
fwrite(&header,sizeof(header),1,v.vfs_fp);
close(v.vfs_fp);
v.vfs_status=VFS_CLOSED;
return 1;
}
